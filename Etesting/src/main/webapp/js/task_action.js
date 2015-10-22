function createUserTask(studentId, taskId) {
    if (confirm('Вы действительно хотите назначить задачу?')) {
        $.ajax({
            type:"POST",
            url:'/e-Testing/admin/AssignTask.html?&userId=' + studentId + '&taskId=' + taskId,
            success:function (data) {
                document.getElementById(studentId + '_' + taskId).textContent = '☑';
                document.getElementById(studentId + '_' + taskId).className = 'label white option disabled';
                document.getElementById(studentId + '_' + taskId).disabled = 'true';
                document.getElementById(studentId + '_' + taskId).style = 'color: black; font-size: 19px;';
            },
            error:function (e) {
                alert('Something is wrong... Try later ');
            }
        });
    }
}

function approveTask(studentId, taskId) {
    $.ajax({
        url:'/e-Testing/admin/GetUserTask.html',
        type:'GET',
        dataType:'json',
        contentType:'application/json',
        mimeType:'application/json',
        data:({
            userId:studentId,
            taskId:taskId
        }),
        success:function (data) {
            var d = document.createElement('div');
            d.setAttribute('id', 'program_info');
            d.innerHTML =
                '<div class="form-group wrapper"> ' +
                    '<div class="input-group">' +
                        '<span style="width: 120px;" class=\"input-group-addon">Плагиат 1 </span>' +
                        '<label id="plagiat1" style="border: none" class="form-control input">' + data.plagiat1 + '</label>' +
                    '</div> ' +
                    '<div class="input-group">' +
                        '<span style="width: 120px;" class="input-group-addon">Плагиат 2 </span> ' +
                        '<label id="plagiat2" style="border: none" class="form-control input">' + data.plagiat2 + '</label>  ' +
                    '</div>' +
                    ' <div class="input-group">' +
                        '<span style="width: 120px;" class="input-group-addon">Номер попытки </span>' +
                        '<label id="try_no" style="border: none" class="form-control input">' + data.tryNo + '</label>' +
                    '</div>' +
                    ' <div class="input-group">' +
                        '<span style="width: 120px;" class="input-group-addon">Нейронная сеть </span>' +
                        '<label id="try_no" style="border: none" class="form-control input">' + data.rightCluster + '</label>' +
                    '</div>' +
                    '</div>';
            document.body.appendChild(d);
            showDialog(studentId, taskId);
        },
        error:function (e) {
            dialog.close();
            alert('Something is wrong... Try later ' + e);
        }
    });
}

function showDialog(studentId, taskId) {
    BootstrapDialog.show({
        title:'Approve/Reject Program',
        message:$('#program_info'),
        buttons:[
            {
                cssClass:'btn-primary',
                label:'Approve',
                action:function (dialog) {
                    $.ajax({
                        type:"POST",
                        data:({
                            userId:studentId,
                            taskId:taskId
                        }),
                        url:'/e-Testing/admin/ApproveTask.html',
                        success:function (data) {
                            document.getElementById(studentId + '_' + taskId).textContent = '\u00a0\u00a0✔\u00a0\u00a0';
                            document.getElementById(studentId + '_' + taskId).className = 'label label-primary option disabled';
                            document.getElementById(studentId + '_' + taskId).disabled = 'true';
                            dialog.close();
                        },
                        error:function (e) {
                            alert('Something is wrong... Try later ');
                        }
                    });
                }
            },
            {
                icon:'glyphicon glyphicon-ban-circle',
                label:' Reject',
                cssClass:'btn-warning',
                action:function (dialog) {
                    $.ajax({
                        type:"POST",
                        data:({
                            userId:studentId,
                            taskId:taskId
                        }),
                        url:'/e-Testing/admin/RejectTask.html',
                        success:function (data) {
                            document.getElementById(studentId + '_' + taskId).textContent = '\u00a0\u00a0✘\u00a0\u00a0';
                            document.getElementById(studentId + '_' + taskId).className = 'label label-default option disabled';
                            document.getElementById(studentId + '_' + taskId).disabled = 'true';
                            dialog.close();
                        },
                        error:function (e) {
                            alert('Something is wrong... Try later ');
                        }
                    });
                }
            },
            {
                label:'Close',
                action:function (dialog) {
                    dialog.close();
                }
            }
        ]
    });
}