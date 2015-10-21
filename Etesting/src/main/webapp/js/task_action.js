function createUserTask(studentId, taskId) {
    if (confirm('Вы действительно хотите назначить задачу?')) {
        $.ajax({
            type:"POST",
            url:'/e-Testing/admin/AssignTask.html?&userId=' + studentId + '&taskId=' + taskId,
            success:function (data) {
                document.getElementById(studentId + '_' + taskId).textContent = '~';
                document.getElementById(studentId + '_' + taskId).className = 'label label-warning option';
                document.getElementById(studentId + '_' + taskId).disabled = 'true';
            },
            error:function (e) {
                alert('Something is wrong... Try later ');
            }
        });
    }
}

function approveTask(studentId, taskId) {
    BootstrapDialog.show({
        title:'Say-hello dialog',
        message:'Select action',
        buttons:[
            {
                cssClass:'btn-primary',
                label:'Approve',
                action:function (dialog) {
                    $.ajax({
                        type:"POST",
                        url:'/e-Testing/admin/ApproveTask.html?&userId=' + studentId + '&taskId=' + taskId,
                        success:function (data) {
                            document.getElementById(studentId + '_' + taskId).textContent = 'OK';
                            document.getElementById(studentId + '_' + taskId).className = 'label label-primary option';
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
                        url:'/e-Testing/admin/RejectTask.html?&userId=' + studentId + '&taskId=' + taskId,
                        success:function (data) {
                            document.getElementById(studentId + '_' + taskId).textContent = 'ø';
                            document.getElementById(studentId + '_' + taskId).className = 'label label-default option';
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
                action:function (dialogItself) {
                    dialogItself.close();
                }
            }
        ]
    });
}