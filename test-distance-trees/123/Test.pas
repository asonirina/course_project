program qwe;
Var FName, Txt : string[10];
    UserFile   : text;
begin
 FName := 'Textfile';
 Assign(UserFile,'out.txt'); {assign a text file}
 Rewrite(UserFile);
 Writeln(UserFile,'1 2 3');

 Close(UserFile);
end.