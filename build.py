import os
import threading

threads = []


def build_application(app):
    threads.append(app)
    print("Building application {}".format(app))
    os.system("cd {} && gradle build".format(app))
    print("Application {} finished building!".format(app))
    threads.remove(app)


def docker_compose_up():
    print("Running containers!")
    os.popen("docker-compose up --build -d").read()
    print("Pipeline finished!")


def run_all_builds():
    threading.Thread(target=build_application,
                     args={"stateless/stateless-auth-api"}).start()
    threading.Thread(target=build_application,
                     args={"stateless/stateless-any-api"}).start()
    threading.Thread(target=build_application,
                     args={"stateful/stateful-auth-api"}).start()
    threading.Thread(target=build_application,
                     args={"stateful/stateful-any-api"}).start()


if __name__ == "__main__":
    print("Pipeline started!")
    print("Removing all containers.")
    os.system("docker-compose down")
    print("Starting to build applications!")
    run_all_builds()
    while len(threads) > 0:
        pass
    threading.Thread(target=docker_compose_up).start()
