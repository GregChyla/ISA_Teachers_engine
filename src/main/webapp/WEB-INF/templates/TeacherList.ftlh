<#include "header.ftlh">

    <div class="container_org">
        <table class="table">
            <#list allTeachers as teacher>
                <tr>
                    <h4>${teacher.firstName} ${teacher.lastName}</h4>
                </tr>
            </#list>
        </table>
    </div>
<#include "footer.ftlh">
