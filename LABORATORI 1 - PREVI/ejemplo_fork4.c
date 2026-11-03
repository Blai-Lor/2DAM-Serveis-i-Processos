#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Error al crear el procés fill");
        exit(1);
    } 
    else if (pid == 0) {
        printf("Soc el procés fill amb PID: %d\n", getpid());
        exit(0);
    } 
    else {
        waitpid(pid, NULL, 0); 
        printf("Soc el procés pare: el meu fill ha finalitzat l'execució.\n");
    }

    return 0;
}