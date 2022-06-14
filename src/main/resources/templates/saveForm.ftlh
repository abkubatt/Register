<!-- FreeMarker Macros -->
<#import "/spring.ftl" as spring/>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="<@spring.url '/table/jquery.dataTables.min.css'/>">
    <script type="text/javascript" src="<@spring.url '/table/jquery-3.5.1.js'/>"></script>
    <script type="text/javascript" src="<@spring.url '/table/jquery.dataTables.min.js'/>" defer></script>

    <script type="text/javascript" class="init">
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>

<body>


<div class="container mb-4 mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Register</div>
                <div class="card-body">
                    <form method="post" action="<@spring.url'/saveForm'/>">
                        <div class="row mb-3">
                            <label for="name" class="col-md-4 col-form-label text-md-end">Name</label>
                            <div class="col-md-6">
                                <input id="name" type="text" class="form-control" name="name" required autocomplete="name" autofocus>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="name" class="col-md-4 col-form-label text-md-end">Surname</label>
                            <div class="col-md-6">
                                <input id="name" type="text" class="form-control" name="surname" required autocomplete="name" autofocus>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="email" class="col-md-4 col-form-label text-md-end">Login</label>
                            <div class="col-md-6">
                                <input id="email" type="text" class="form-control" name="login">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="email" class="col-md-4 col-form-label text-md-end">Email</label>
                            <div class="col-md-6">
                                <input id="email" type="text" class="form-control" name="email">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="email" class="col-md-4 col-form-label text-md-end">Patronymic</label>
                            <div class="col-md-6">
                                <input id="email" type="text" class="form-control" name="patronymic">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="password" class="col-md-4 col-form-label text-md-end">Password</label>
                            <div class="col-md-6">
                                <input id="password" type="password" class="form-control"name="password" required autocomplete="new-password">
                            </div>
                        </div>

                        <div class="row mb-0">
                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">
                                    Register
                                </button>
                            </div>
                        </div>
                        <#--                        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
                    </form>
                </div>
            </div>
        </div>
    </div>

    <#--<div>-->
    <#--    ${users}-->
    <#--</div>-->


</div>

<div class="container mb-4 mt-4">
    <div class="demo-html">
        <div id="example_wrapper" class="">
            <table id="example" class="table table-bordered border-primary" style="width: 100%;" aria-describedby="example_info">
                <thead>
                <tr>
                    <th class="sorting sorting_asc" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
                        id
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 20%;">
                        name
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 30%;">
                        login
                    </th>
                    <th class="sorting" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 15%;">
                        email
                    </th>
                    <th class="sorting text-center" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 25%;">
                        password
                    </th>
                    <th class="sorting text-center" tabindex="0" aria-controls="example" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 25%;">
                        surname
                    </th>

                </tr>
                </thead>
                <tbody>
                <#list users as user>
                    <tr class="odd">
                        <td class="sorting_1">${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.login}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.surname}</td>


                    </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>
