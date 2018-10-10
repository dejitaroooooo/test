var i;
var j;
document.write("<h1>★の出力</h1>");
document.write("解1<br>");
for(i=0;i<5;i++){
    document.write("★");
}

document.write("<br><br>解2<br>");
for(i=0;i<2;i++){
    for(j=0;j<3;j++)
        document.write("★");
    document.write("<br>");
}

document.write("<br><br>解3<br>");
for(i=0;i<2;i++){
    for(j=0;j<5;j++)
        document.write("☆");
    document.write("<br>");
}

document.write("<br><br>解4<br>");
for(i=0;i<3;i++){
    for(j=0;j<5;j++)
        document.write("★");
    document.write("<br>");
}

document.write("<br><br>解5<br>");
for(i=0;i<4;i++){
    for(j=0;j<3;j++)
        document.write("★");
    document.write("<br>");
}

document.write("<br><br>解6<br>");
for(i=0;i<3;i++){
    for(j=0;j<3;j++){
        if(j%2==0)
            document.write("★");
        else
            document.write("☆");
    }
    document.write("<br>");
}

document.write("<br><br>解7<br>");
for(i=0;i<3;i++){
    for(j=0;j<5;j++){
        if(j%2==0)
            document.write("★");
        else
            document.write("☆");
    }
    document.write("<br>");
}

document.write("<br><br>解8<br>");
for(i=0;i<5;i++){
    for(j=0;j<=i;j++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>")
document.write("<h1>----------------------<br>関数</h1>");

/*関数*/
document.write("解1<br>");
function area(radius){    
    return "半径" + radius + "cmの円の面積は " + radius*radius*3.14;
}
document.write(area(5)+"<br>");
document.write(area(7)+"<br>");
document.write(area(10)+"<br>");


document.write("<br><br>解2<br>");
function total(group, adult,child){

    return group+ "グループの合計金額は" + (adult*500 + child*200) + "円です。";
}
document.write(total("A",2,4)+"<br>");
document.write(total("B",1,5)+"<br>");
document.write(total("C",3,7)+"<br>");


