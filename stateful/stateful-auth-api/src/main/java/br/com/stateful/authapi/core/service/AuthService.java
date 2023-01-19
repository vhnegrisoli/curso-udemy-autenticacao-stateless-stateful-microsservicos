package br.com.stateful.authapi.core.service;

import br.com.stateful.authapi.core.dto.AuthRequest;
import br.com.stateful.authapi.core.dto.AuthUserResponse;
import br.com.stateful.authapi.core.dto.TokenDTO;
import br.com.stateful.authapi.core.model.User;
import br.com.stateful.authapi.core.repository.UserRepository;
import br.com.stateful.authapi.infra.exception.AuthenticationException;
import br.com.stateful.authapi.infra.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;;
    private final TokenService tokenService;

    public TokenDTO login(AuthRequest request) {
        var user = findByUsername(request.username());
        validatePassword(request.password(), user.getPassword());
        var accessToken = tokenService.createToken(user.getUsername());
        return new TokenDTO(accessToken);
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new ValidationException("The password is incorrect!");
        }
    }

    public TokenDTO validateToken(String token) {
        validateExistingToken(token);
        var valid = tokenService.validateAccessToken(token);
        if (valid) {
            return new TokenDTO(token);
        }
        throw new AuthenticationException("Invalid token!");
    }

    private void validateExistingToken(String token) {
        if (isEmpty(token)) {
            throw new ValidationException("The access token must be informed!");
        }
    }

    public AuthUserResponse getAuthenticatedUser(String token) {
        var tokenData = tokenService.getTokenData(token);
        var user = findByUsername(tokenData.username());
        return new AuthUserResponse(user.getId(), user.getUsername());
    }

    public void logout(String token) {
        tokenService.deleteRedisToken(token);
    }

    private User findByUsername(String username) {
        return repository
            .findByUsername(username)
            .orElseThrow(() -> new ValidationException("User not found!"));
    }
}
