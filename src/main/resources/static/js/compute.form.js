$('#s_btn').click(function () {

    var name = $('#s_name').val();
    var center = $('#s_center').val();
    var start = $('#s_start').val();
    var over = $('#s_over').val();

    var data = {name:name,center:center,start:start,over:over};
    var url = ctx+'compute_form';

    if(start==''&&over!=''){
        my_alert("请输入开始时间！");
        return;
    }

    window.location.href= url+'?name='+name+'&center='+center+'&start='+start+'&over='+over;


    // $.ajax({
    //     type:"POST",
    //     url:ctx+'compute_form',
    //     async:false,
    //     data:data,
    //     success:function(result){  //function1()
    //         // if(result.resultCode==1){
    //         //     // my_alert(result.result);
    //         //     // location.reload();
    //         //     // window.location.href=ctx+'compute_form';
    //         // }else {
    //         //     // my_alert(result.resultMessage);
    //         // }
    //     }
    //
    // });

});



$('#add_btn').click(function () {



    window.location.href=ctx+'compute';




});



$(function() {
    $('#doc-form-file').on('change', function() {
        var fileNames = '';
        $.each(this.files, function() {
            fileNames += '<span class="am-badge">' + this.name + '</span> ';
        });
        $('#file-list').html(fileNames);
    });
});

$('#import_btn').click(function(){


    $('#my-prompt-import').modal({
        relatedTarget: this,
        onConfirm: function(e) {

            $("#import_form").ajaxSubmit({
                type: "POST",
                url:ctx+"compute/readExcel",
                dataType: "json",
                // data:data,
                success: function(result){
                    // result = JSON.parse(result);
                    if(result.resultCode == 1) {

                        alert('上传成功！');
                    }else{
                        alert(result.resultMessage);
                        return;
                    }
                }
            });



        },

        onCancel: function() {
            $('#file-list').html('');
        }


    });




});



function edit(id) {
    window.location.href=ctx+"compute?id="+id;

}


function  remove(id) {
    $('#my_message').html("你确定要删除么！");
    $('#my_alert').modal({
        relatedTarget: this,
        onConfirm: function(options) {
            $.ajax({
                type:"POST",
                url:ctx+'compute/delete',
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

