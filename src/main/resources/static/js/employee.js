$('#add_btn').click(function () {


    $('#my-prompt').modal({
        relatedTarget: this,
        onConfirm: function(e) {

            $.ajax({
                type:"POST",
                url:ctx+'employee/add',
                data:{"name":$("#name").val(),'center':$('#center').val(),'position':$('#position').val()},
                success:function(result){  //function1()
                    if(result.resultCode==1){
                        alert("操作成功");
                        location.reload();
                    }else {
                        alert(result.resultMessage);

                    }
                }

            });
            resetValue();
        },

        onCancel: function() {
            resetValue();
        }


    });


});


function edit(id) {
 var id = id;
 var url = ctx+'employee/selectForId';
 var param={'id':id};
    // var roleName;
    // var roleRemark;
    // var classMoney;

    $.ajax({
        type:"POST",
        url:url,
        data:param,
        async: false,
        success:function(result){  //function1()
            $('#name').val(result.name);
            $('#center').val(result.center);
            $('#position').val(result.position);
            // $('#center').find('option').eq(2).attr('selected', true);
            // $('#position').selected(result.position);


            // $("#center").attr("value", result.center);
            // $("#position").attr("value", result.position);

            // roleName = result.roleName;
            // roleRemark = result.roleRemark;
            // classMoney = result.classMoney;
        }

    });


    // $('#roleName').val(roleName);
    // $('#roleRemark').val(roleRemark);
    // $('#classMoney').val(classMoney);


    $('#my-prompt').modal({
        relatedTarget: this,
        onConfirm: function(e) {

            $.ajax({
                type:"POST",
                url:ctx+'employee/update',
                data:{"name":$("#name").val(),'center':$('#center').val(),'position':$('#position').val(),'id':$('#id').val()},
                success:function(result){  //function1()
                    if(result.resultCode==1){
                        alert(result.resultMessage);
                        location.reload();
                    }else {
                        alert(result.resultMessage);

                    }
                }

            });

            resetValue();
        },

        onCancel: function() {
            resetValue();
        }
    });



}

$('#my_alert').on('closed.modal.amui', function() {
    $(this).removeData('amui.modal');
});


function  remove(id) {
    $('#my_message').html("你确定要删除么！");
    $('#my_alert').modal({
        relatedTarget: this,
        onConfirm: function(options) {
            $.ajax({
                type:"POST",
                url:ctx+'employee/delete',
                data:{'id':id},
                async: false,
                success:function(result){  //function1()
                    if(result.resultCode==1){
                        // my_alert(result.resultMessage)
                        alert(result.resultMessage);
                        location.reload();
                    }else {
                        my_alert(result.resultMessage)
                        // alert(result.resultMessage);
                    }
                }
            });

        },
        onCancel: function() {
            $(this).removeData('amui.modal');
        }
    });

}

function  resetValue() {
    $("#name").val("");
    $("#center").val("");
    $("#position").val("");
    // $("#classMoney").val("");
}

// function  resetValue_lbs() {
//     $("#level").val("");
//     $("#classMoney_lbs").val("");
// }
//
// /**
//  * 乐博士
//  */
// function add_lbs() {
//
//     $('#prompt_lbs').modal({
//         relatedTarget: this,
//         onConfirm: function(e) {
//
//             $.ajax({
//                 type:"POST",
//                 url:ctx+'teacher/add_lbs',
//                 data:{"level":$("#level").val(),'classMoney':$('#classMoney_lbs').val()},
//                 success:function(result){  //function1()
//                     if(result.resultCode==1){
//                         alert("操作成功");
//                         location.reload();
//                     }else {
//                         my_alert(result.resultMessage);
//                     }
//                 }
//             });
//             resetValue_lbs();
//         },
//
//         onCancel: function() {
//             resetValue_lbs();
//         }
//     });
// }
//
// function edit_lbs(id) {
//
//     var id = id;
//     var url = ctx+'teacher/selectForIdLbs'
//     var param={'id':id};
//     var level;
//     var classMoney;
//     $.ajax({
//         type:"POST",
//         url:url,
//         data:param,
//         async: false,
//         success:function(result){  //function1()
//             level = result.level;
//             classMoney = result.classMoney;
//         }
//
//     });
//
//
//     $('#level').val(level);
//     $('#classMoney_lbs').val(classMoney);
//
//
//     $('#prompt_lbs').modal({
//         relatedTarget: this,
//         onConfirm: function(e) {
//
//             $.ajax({
//                 type:"POST",
//                 url:ctx+'teacher/update_lbs',
//                 data:{"level":$("#level").val(), 'classMoney':$('#classMoney_lbs').val(),'id':id},
//                 success:function(result){  //function1()
//                     if(result.resultCode==1){
//                         alert(result.resultMessage);
//                         location.reload();
//                     }else {
//                        my_alert(result.resultMessage);
//
//                     }
//                 }
//
//             });
//
//             resetValue_lbs();
//         },
//
//         onCancel: function() {
//             resetValue_lbs();
//         }
//     });
//
//
// }
//
//
// function remove_lbs(id) {
//     $('#my_message').html("你确定要删除么！");
//     $('#my_alert').modal({
//         relatedTarget: this,
//         onConfirm: function(options) {
//             $.ajax({
//                 type:"POST",
//                 url:ctx+'teacher/delete_lbs',
//                 data:{'id':id},
//                 async: false,
//                 success:function(result){  //function1()
//                     if(result.resultCode==1){
//                         // my_alert(result.resultMessage)
//                         alert(result.resultMessage);
//                         location.reload();
//                     }else {
//                         my_alert(result.resultMessage)
//                         // alert(result.resultMessage);
//                     }
//                 }
//             });
//
//         },
//         onCancel: function() {
//             $(this).removeData('amui.modal');
//         }
//     });
//
//
// }