#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int variable_global = 100;
int main() {
    int variable_local = 200;
    
    pid_t pid = fork();
    
    if (pid < 0) {
        perror("Error en el fork");
        exit(1);
    }
    else if (pid == 0) {
        variable_global = 999;
        variable_local = 888;
        
        printf("[Fill] Variables modificades -> global: %d, local: %d\n", variable_global, variable_local);
        exit(0);
    }
    else {
        waitpid(pid, NULL, 0);
        printf("[Pare] Variables originals -> global: %d, local: %d\n", variable_global, variable_local);
    }
    
    return 0;
}