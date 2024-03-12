# Instruction
1. Build docker image
    ```shell
    docker buildx build -t notification-service:0.0.1 .
    ```
2. Add tag to image
    ```shell
    docker tag notification-service:0.0.1 otuslearning/notification-service:0.0.1
    ```
3. Push image
    ```shell
    docker push otuslearning/notification-service:0.0.1
    ```