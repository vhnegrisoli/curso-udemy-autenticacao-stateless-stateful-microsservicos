package br.com.stateless.authapi.core.service;

import br.com.stateless.authapi.core.dto.AuthRequest;
import br.com.stateless.authapi.core.dto.TokenDTO;
import br.com.stateless.authapi.core.repository.UserRepository;
import br.com.stateless.authapi.infra.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;;
    private final JwtService jwtService;

    public TokenDTO login(AuthRequest request) {
        var user = repository
            .findByUsername(request.username())
            .orElseThrow(() -> new ValidationException("User not found!"));
        validatePassword(request.password(), user.getPassword());
        var accessToken = jwtService.createToken(user);
        return new TokenDTO(accessToken);
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new ValidationException("The password is incorrect!");
        }
    }

    public TokenDTO validateToken(TokenDTO request) {
        validateExistingToken(request);
        jwtService.validateAccessToken(request.accessToken());
        return request;
    }

    private void validateExistingToken(TokenDTO request) {
        if (isEmpty(request) || isEmpty(request.accessToken())) {
            throw new ValidationException("The access token must be informed!");
        }
    }
}
