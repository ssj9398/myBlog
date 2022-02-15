<h3 align="center"><b>항해99 미니 개인 프로젝트 블로그 만들기</b></h3>

<h4 align="center">📆 2022.02.11 ~ 2022</h4>
<br>
<br>

---

<br>
<h3 align="center"><b>🛠 Tech Stack 🛠</b></h3>
<p align="center">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/Thymeleaf-green?style=for-the-badge&logo=Thymeleaf&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-Purple?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/jquery-1572B6?style=for-the-badge&logo=jquery&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">

</br>

<img src="https://img.shields.io/badge/java1.8-539bf5?style=for-the-badge&logo=java1.8&logoColor=white">
<img src="https://img.shields.io/badge/jpa-green?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/spring%20data%20jpa-green?style=for-the-badge&logo=springdatajpa&logoColor=white">
<img src="https://img.shields.io/badge/gradle-1f4954?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/Junit5-green?style=for-the-badge&logo=Junit5&logoColor=white">
<img src="https://img.shields.io/badge/mysql-skyblue?style=for-the-badge&logo=mysql&logoColor=white">

</br>

<img src="https://img.shields.io/badge/awsrds-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/naverCloud-green?style=for-the-badge&logo=naverCloud&logoColor=white">
<img src="https://img.shields.io/badge/ubuntu-orange?style=for-the-badge&logo=ubuntu&logoColor=white">
<img src="https://img.shields.io/badge/gitAction-181717?style=for-the-badge&logo=gitAction&logoColor=white">
<img src="https://img.shields.io/badge/docker-blue?style=for-the-badge&logo=docker&logoColor=white">

</br>

<br><br>

---


<br>
<h3 align="center"><b>📢 Main function 📢</b></h3>
<br>
<h4><b>📰 boardList 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/48196352/154000766-66810795-f139-455f-a956-0de13ace0c13.JPG" /></td>
        <td width="50%">
            <h5>게시글 리스트</h5>
            <ul>
                <li>수정 및 삭제 기능</li>
            </ul>
        </td>
    </tr>
</table>

<br>

<h4><b>📰 Write 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/48196352/154000857-05be61c6-a788-4fca-a5f0-5e9845b0560e.JPG" /></td>
        <td width="50%">
            <h5>게시글 쓰기</h5>
            <ul>
                <li>게시글 등록</li>
            </ul>
        </td>
    </tr>
</table>

<br>
<h4><b>📰 boardDetails & Comment 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/48196352/154001177-fc9db7fc-a5d7-4c2a-a4b6-9df2ed4118aa.JPG" /></td>
        <td width="50%">
            <h5>상세페이지 & 댓글</h5>
            <ul>
                <li>게시글 상세정보, 댓글등록, 수정, 삭제</li>
            </ul>
        </td>
    </tr>
</table>

<br>
<h4><b>📰 Edit 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/48196352/154001181-ecadcd7a-1ff2-4b83-a705-3144691a0bab.JPG" /></td>
        <td width="50%">
            <h5>게시글 수정</h5>
            <ul>
                <li>등록된 게시글 수정</li>
            </ul>
        </td>
    </tr>
</table>



---


<br><br>

<h3 align="center"><b>🏷 API Table 🏷</b></h3>

|function|method|urI|Request|Response|
|------|---|---|---|---|
|게시글 등록|POST|/post|{"title":"title","writer":"writer","content":"content"}|{"success":true,"msg": "게시글 등록 완료!"}|
|게시글 전체 조회|GET|post||{"id": id, "title": title, "writer": writer, "content": content, "boardDate": "2022-02-14T23:46:34.83317","comment": [{ "id": id,  "contents": contents: , "commentDate": "2022-02-14T23:46:41.06443"},{"id": id,  "contents": contents: , "commentDate":"2022-02-14T23:46:41.06443"}]}|
|상세 게시글 조회|GET|/post/{board_id}||{"id": id, "title": title, "writer": writer, "content": content, "boardDate": "2022-02-14T23:46:34.83317","comment": [{ "id": id,  "contents": contents: , "commentDate": "2022-02-14T23:46:41.06443"},{"id": id,  "contents": contents: , "commentDate":"2022-02-14T23:46:41.06443"}]}|
|게시글 삭제|DELETE|/post/{board_id}||{"success": true,"msg": "게시글 삭제 완료!"}|
|게시글 수정|PATCH|/post/{board_id}|테스트3|{"success": true,"msg": "게시글 수정 완료!"}|
|댓글 등록|POST|/comment/{post_id}|테스트3|{"success": true,"msg": "댓글 등록 완료!"}|
|댓글 조회|GET|/comment/{post_id}||{"id": id,  "contents": contents: , "commentDate": "2022-02-14T23:46:41.06443"},|
|댓글 삭제|DELETE|/comment/{comment_id}||{"success": true,"msg": "댓글 삭제 완료!"}|
|댓글 수정|PATCH|/comment/{comment_id}|{"comments":"comments"}|{"success": true,"msg": "댓글 수정 완료!"}|



---
