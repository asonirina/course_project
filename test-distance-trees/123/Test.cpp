#include <fstream>

int main()
{
   std::ofstream fout("out.txt");
   fout << "1 2 3";

   fout << std::endl;

}