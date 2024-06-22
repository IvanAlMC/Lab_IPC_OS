#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  int tubo[2];
  pipe(tubo);
  if (fork() == 0) {
    dup2(tubo[0], STDIN_FILENO);
    close(tubo[1]);
    close(tubo[0]);
    execlp("sort", "sort", NULL);
  } else {
    dup2(tubo[1], STDOUT_FILENO);
    close(tubo[0]);
    close(tubo[1]);
    execlp("ls", "ls", NULL);
  }
  return 0;
}
