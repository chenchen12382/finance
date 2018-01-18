<html>
    <head>
        <#include "include/test.ftl" />
    </head>
    <body>
        <table>
            <tr>
                <th>UserId</th>
                <th>UserName</th>
                <th>Gender</th>
            </tr>
        [#list users as user ]
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.Gender}</td>
            </tr>
        [/#list]


        </table>

    </body>
</html>