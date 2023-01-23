import os
import threading

stateless_path = '\stateless'
stateful_path = '\stateful'
full_path = os.getcwd()
stateless_auth_api_path = stateless_path + '\stateless-auth-api'
stateless_any_api_path = stateless_path + '\stateless-any-api'
stateful_auth_api_path = stateful_path + '\stateful-auth-api'
stateful_any_api_path = stateful_path + '\stateful-any-api'
build_command = 'gradle build'
threads = []


def build_application(application_path):
    threads.append(application_path)
    build_path = full_path + application_path
    print('Building application ' + application_path)
    os.popen('cd ' + build_path + ' && ' + build_command).read()
    print("Application " + application_path + " finished building!")
    threads.remove(application_path)


def docker_compose_up():
    print("Running containers!")
    os.popen("docker-compose up --build -d").read()
    print("Pipeline finished!")


if __name__ == "__main__":
    print("Pipeline started!")
    print("Removing all containers.")
    os.system("docker-compose down")
    print("Starting to build applications!")

    threading.Thread(target=build_application, args={
                     stateless_auth_api_path}).start()
    threading.Thread(target=build_application, args={
                     stateless_any_api_path}).start()
    threading.Thread(target=build_application, args={
                     stateful_auth_api_path}).start()
    threading.Thread(target=build_application, args={
                     stateful_any_api_path}).start()

    while len(threads) > 0:
        pass

    threading.Thread(target=docker_compose_up).start()
