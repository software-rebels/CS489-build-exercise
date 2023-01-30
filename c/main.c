#include <stdio.h>
#include <stdlib.h>

#include "config.h"
#include "input.h"
#include "job.h"

int main(int argc, const char *argv[]) {
  char *dir = NULL;
  int job = -1;

  if ((dir = get_dir()) == NULL) {
    goto cleanup;
  }
  
  for (; job < NUM_JOBS;) {
    job = create_job(dir);
    if (job == -1) {
      goto cleanup;
    }

    printf("Created job %d in directory %s\n", job, dir);
  }

cleanup:
  printf("cleaning up!\n");
  char cmd[128] = {0};
  snprintf(cmd, 128, "rmdir %s", dir);
  int ret = system(cmd);
  if (ret==0){
    printf("removed directory \"%s\" successfully\n", dir);
  } else {
    printf("error removing directory \"%s\"\n", dir);
  }
  free(dir);
  dir = NULL;

  return 0;
}
