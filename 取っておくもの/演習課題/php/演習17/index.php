<!DOCTYPE html>
<html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>4eachblog 掲示板</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    
    <body>
        
        <!--PHPコード-->
        <?php
        mb_internal_encoding("utf8");
        $pdo=new PDO("mysql:dbname=lesson_oode;host=localhost;","root","mysql");
        $stmt=$pdo->query("select * from 4each_keijiban");
        ?>

        <!--ヘッダー-->
        <header>
            <div class="logo">
                <img src="4eachblog_logo.jpg">
            </div>
            <div class="menue">
                <ul>                    
                    <li>トップ</li>
                    <li>プロフィール</li>
                    <li>4eachについて</li>
                    <li>登録フォーム</li>
                    <li>問い合わせ</li>
                    <li>その他</li>
                </ul>
            </div>
        </header>
        
        <!--メインコンテンツ-->
        <main>
            <div class="main-container">
                <!--左側-->
                <div class="left">
                    <h1>プログラミングに役立つ掲示板</h1>
                    <!--入力フォーム-->
                    <form method="post" action="insert.php">
                        <h2>入力フォーム</h2>
                        <div>
                            <label>ハンドルネーム</label>
                            <br>
                            <input type="text" class="text" size="35px" name="handlename">
                        </div>
                        <div>
                            <label>タイトル名</label>
                            <br>
                            <input type="text" class="text" size="35px" name="title">
                        </div>
                        <div>
                            <label>コメント</label>
                            <br>
                            <textarea rows="7" cols="50" name="comments"></textarea>
                        </div>
                        <div>
                            <input type="submit" class="submit" value="投稿する">
                        </div>
                    </form>
                
                    <?php
                    while($row=$stmt->fetch()){
                        echo "<div class='kiji'>";
                        echo "<h3>".$row['title']."</h3>";
                        echo "<div class='contens'>";
                        echo $row['comments'];
                        echo "<div class='handlename'>posted by ".$row['handlename']."</div>";
                        echo "</div>";
                        echo "</div>";
                    }
                    ?>
                    
                </div>
                <!--右側-->
                <div class="right">
                    <h2>人気の記事</h2> 
                        <ul>
                            <li>PHP オススメ本</li>
                            <li>PHP MyAdminの使い方</li>
                            <li>今人気のエディタ Top5</li>
                            <li>HTMLの基礎</li>
                        </ul>
                    <h2>オススメリンク</h2> 
                        <ul>
                            <li>インターノウス株式会社</li>
                            <li>XAMPPのダウンロード</li>
                            <li>Eclipseのダウンロード</li>
                            <li>Bracketsのダウンロード</li>
                            </ul>
                    <h2>カテゴリ</h2> 
                        <ul>
                            <li>HTML</li>
                            <li>PHP</li>
                            <li>MySQL</li>
                            <li>JavaScript</li>
                    </ul>
                </div>
            </div>
        </main>
        
        <!--フッター-->
        <footer>
            copyright (C) internous | 4each blog is the one whitch provides A to Z about programming.            
        </footer>
        
    </body>
    
</html>