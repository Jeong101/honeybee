# Branch
## Branch:jeong101 added
```
google account - ID : climbHoneybee5sound@gmail.com
```

# SQL Qurey
``` sql
CREATE DATABASE honeybee;
CREATE USER 'honeybee' IDENTIFIED BY 'honeybee123';

GRANT ALL PRIVILEGES ON *.* TO 'honeybee'@'%';
```

# club dummy data
``` sql
INSERT INTO club(id, club_name) VALUES(1, 'honeybee');
INSERT INTO club(id, club_name) VALUES(2, '5sound');
```

# youtubeAPI 추가 후 동의화면 업데이트