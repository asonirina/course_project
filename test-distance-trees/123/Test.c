#include <stdio.h>

main()
{
   FILE *fp;

   fp = fopen("out.txt", "w+");
//   fprintf(fp, "1 2 3");
   fputs("1 2 3", fp);
   fclose(fp);
}