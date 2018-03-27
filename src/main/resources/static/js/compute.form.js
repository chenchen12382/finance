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







