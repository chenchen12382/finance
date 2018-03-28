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


$('#compute_btn').click(function () {

    var str = $('#select_name').val();
    var work = str.split(',')[1];
    // alert(work);


    if(work.indexOf("教师") != -1 || work.indexOf("助教") != -1 ){
        // 教师
        if(work.indexOf("亲子教师") != -1||work.indexOf("Dookey ABC助教") != -1){

            $('#my-prompt-1').modal({
                relatedTarget: this,
                onConfirm: function(e) {
                    var destroyNum = $('#destroyNum').val();
                    var count;
                    if(destroyNum<200){
                        count=destroyNum*5;
                    }else if(destroyNum>=200 && destroyNum<400){
                        count=destroyNum*10
                    }else {
                        count = destroyNum*15;
                    }

                    var amountUp=$('#amountUp').val()*100;
                    var amountDown = $('#amountDown').val()*50;

                    var bbj = amountDown+amountUp;

                    $('#f_ksf').val(count);

                    $('#f_bbj').val(bbj);

                    resetValueQZ();
                },

                onCancel: function() {
                    resetValueQZ();
                }


            });


        }else {

                $('#my-prompt-1').modal({
                    relatedTarget: this,
                    onConfirm: function(e) {
                        var destroyNum = $('#destroyNum').val();
                        var count;
                        if(work.indexOf("主教") != -1) {
                             count = destroyNum * 5;
                        }else {
                             count = destroyNum * 1;
                        }

                        var amountUp=$('#amountUp').val()*100;
                        var amountDown = $('#amountDown').val()*50;

                        var bbj = amountDown+amountUp;

                        $('#f_ksf').val(count);

                        $('#f_bbj').val(bbj);

                        resetValueQZ();
                    },

                    onCancel: function() {
                        resetValueQZ();
                    }


                });

        }





    }else if(work.indexOf('教学主管') != -1){
        // 教学主管

            $('#my-prompt-3').modal({
                relatedTarget: this,
                onConfirm: function(e) {

                    var hyrs=$('#hyrs').val();
                    var bbj_dowm  = $('#bbj_dowm').val();
                    var bbj_up =$('#bbj_up').val();
                    var count ;
                    if(work.indexOf('初级') != -1) {
                        $('#f_dx').val('5000');
                        count=bbj_dowm*80 + bbj_up*100;
                    }else if(work.indexOf('中级') != -1){
                        $('#f_dx').val('6000');
                        count=bbj_dowm*100 + bbj_up*120;
                    }else {
                        //高级教学主管
                        $('#f_dx').val('7000');
                        count=bbj_dowm*120 + bbj_up*150;
                    }

                    $('#f_tcjj').val(count);
                     var tc = 0;
                    if(hyrs >=800 && hyrs <1500){
                      tc=hyrs
                    }else if(hyrs>1500){
                        tc=hyrs*2;
                    }

                    $('#f_bbj').val(tc);



                    resetValueZG();
                },

                onCancel: function() {
                    resetValueZG();
                }

            });


    }else if(work.indexOf('顾问') != -1){
        // 顾问

        $('#my-prompt-2').modal({
            relatedTarget: this,
            onConfirm: function(e) {
                var bywcyj = $('#bywcyj').val();
                var yjdbbl = $('#yjdbbl').val();
                var count = 0;
                if(bywcyj>=60000 && bywcyj <110000 ){
                    count = bywcyj * 0.02
                }else if(bywcyj>=110000 && bywcyj < 160000){
                    count = bywcyj * 0.03
                }else if (bywcyj>160000){
                    //大于16w
                    count = bywcyj * 0.04
                }
                if(work.indexOf('助理') != -1){
                    countDx(yjdbbl,3000);

                }else if(work.indexOf('初级') != -1){
                  // 初级顾问
                    countDx(yjdbbl,4000);
                }else if(work.indexOf('中级') != -1){
                    // 中级顾问
                    countDx(yjdbbl,5000);

                }else{
                    // 高级顾问
                    countDx(yjdbbl,6000);
                }

                $('#f_tcjj').val(Math.round(count))

                resetValueGW();
            },

            onCancel: function() {
                resetValueGW();
            }


        });


    }else if(work.indexOf('中心经理') != -1){
        // 中心经理
        $('#my-prompt-4').modal({
            relatedTarget: this,
            onConfirm: function(e) {
            var yjdbbl = $('#yjdbbl_jl').val();
            var yjze = $('#yjze').val();
                if(work.indexOf('初级') != -1){
                    countZxjl(yjdbbl,yjze,7000);

                }else if(work.indexOf('中级') != -1){
                    countZxjl(yjdbbl,yjze,8000);

                }else if(work.indexOf('高级') != -1){
                    countZxjl(yjdbbl,yjze,9000);

                }else{
                    countZxjl(yjdbbl,yjze,10000);
                }


                resetValueZXJL();
            },

            onCancel: function() {
                resetValueZXJL();
            }


        });



    }else{
        // 其它

        alert('该职位没有提成方案!')
    }



});




$('#add_btn').click(function () {

    var name=$('#f_name').val();
    var center=$('#f_center').val();
    var sfz=$('#f_sfz').val();
    var work=$('#f_work').val();
    var dx=$('#f_dx').val();
    var gwgz=$('#f_gwgz').val();
    var jxgz=$('#f_jxgz').val();
    var bmf=$('#f_bmf').val();
    var gzbc=$('#f_gzbc').val();
    var cqts=$('#f_cqts').val();
    var bfgz=$('#f_bfgz').val();
    var ft=$('#f_ft').val();
    var jt=$('#f_jt').val();
    var yeybt=$('#f_yeybt').val();
    var tcjj=$('#f_tcjj').val();
    var bbj=$('#f_bbj').val();
    var ccbt=$('#f_ccbt').val();
    var jxxs=$('#f_jxxs').val();
    var cjkk=$('#f_cjkk').val();
    var sjkk=$('#f_sjkk').val();
    var bjkk=$('#f_bjkk').val();
    var kgkk=$('#f_kgkk').val();
    var cdkk=$('#f_cdkk').val();
    var qtkk=$('#f_qtkk').val();
    var yfgz=$('#f_yfgz').val();
    var grsbhj=$('#f_grsbhj').val();
    var grgjj=$('#f_grgjj').val();
    var grsds=$('#f_grsds').val();
    var qysbhj=$('#f_qysbhj').val();
    var qygjj=$('#f_qygjj').val();
    var gzze=$('#f_gzze').val();


    my_NAN(dx,'基本工资必须为数字！');
    my_NAN(gwgz,'岗位工资必须为数字！');
    my_NAN(jxgz,'绩效工资必须为数字！');
    my_NAN(bmf,'保密费必须为数字！');
    my_NAN(gzbc,'工资补差必须为数字！');
    my_NAN(cqts,'出勤天数必须为数字！');
    my_NAN(bfgz,'补发工资必须为数字！');
    my_NAN(ft,'饭贴必须为数字！');
    my_NAN(jt,'津贴必须为数字！');
    my_NAN(yeybt,'幼儿园补贴必须为数字！');
    my_NAN(tcjj,'提成奖金必须为数字！');
    my_NAN(bbj,'报班奖必须为数字！');
    my_NAN(ccbt,'出差补贴必须为数字！');
    my_NAN(jxxs,'绩效系数必须为数字！');
    my_NAN(cjkk,'产假扣款必须为数字！');
    my_NAN(sjkk,'事假扣款必须为数字！');
    my_NAN(bjkk,'病假扣款必须为数字！');
    my_NAN(kgkk,'旷工扣款必须为数字！');
    my_NAN(cdkk,'迟到扣款必须为数字！');
    my_NAN(qtkk,'其它扣款必须为数字！');
    my_NAN(yfgz,'应发工资必须为数字！');
    my_NAN(grsbhj,'个人社保合计必须为数字！');
    my_NAN(grgjj,'个人公积金必须为数字！');
    my_NAN(grsds,'个人所得税必须为数字！');
    my_NAN(qysbhj,'企业社保合计必须为数字！');
    my_NAN(qygjj,'企业公积金必须为数字！');
    my_NAN(gzze,'实发工资必须为数字！');


    var  data = {'name':name,'center':center,'sfz':sfz,'work':work,'dx':dx,'gwgz':gwgz,'jxgz':jxgz,'bmf':bmf,'gzbc':gzbc,
        'cqts':cqts,'bfgz':bfgz,'ft':ft,'jt':jt,'yeybt':yeybt,'tcjj':tcjj,'bbj':bbj,'ccbt':ccbt,'jxxs':jxxs,'cjkk':cjkk,'sjkk':sjkk,'bjkk':bjkk,
         'kgkk':kgkk,'cdkk':cdkk,'qtkk':qtkk,'yfgz':yfgz,'grsbhj':grsbhj,'grgjj':grgjj,'grsds':grsds,'qysbhj':qysbhj,'qygjj':qygjj,'gzze':gzze}


    $.ajax({
        type:"POST",
        url:ctx+'compute/add',
        data:data,
        success:function(result){  //function1()
            if(result.resultCode==1){
                alert(result.result);
                window.location.href=ctx+'compute_form';
            }else {
                alert(result.resultMessage);
            }
        }

    });

});


function my_NAN(num,message) {
    if(!isNaN(num)){
        my_alert(message);
        return;
    }
}







function edit(id) {
 var id = id;
 var url = ctx+'role/selectForId';
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
            $('#roleName').val(result.roleName);
            $('#roleRemark').val(result.roleRemark);

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
                url:ctx+'role/update',
                data:{"roleName":$("#roleName").val(),'roleRemark':$('#roleRemark').val(), 'id':id},
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

//计算顾问底薪达标比例
function countDx(yjdbbl,num) {
    if(yjdbbl>100){
        alert("最多为100! 大于按100算！")
        yjdbbl=100;
    }

    var bl = yjdbbl/100;
    if(yjdbbl<80){
        $('#f_dx').val(num*0.8);
    }else if(yjdbbl>=80 && yjdbbl < 90){
        $('#f_dx').val(num*bl);
    }else{
        $('#f_dx').val(num)
    }

}

//计算中心经理薪资
function countZxjl(yjdbbl,yjze,num) {
    var bl = yjdbbl/100;
    if(yjdbbl<60){

        $('#f_dx').val(yjdbbl*0.6);

    }else if(yjdbbl<80 && yjdbbl>=60){
        $('#f_dx').val(num*bl);

    }else if(yjdbbl<90&&yjdbbl>=80){
        $('#f_dx').val(num-1000);

    }else if(yjdbbl<100 && yjdbbl>=90){

        $('#f_dx').val(num);

    }else if(yjdbbl<120 && yjdbbl>=100){

        $('#f_dx').val(num + yjze*0.012);

    }else if(yjdbbl<140 && yjdbbl>=120){

        $('#f_dx').val(num + yjze * 0.014);
    }else{

        $('#f_dx').val(num + yjze * 0.016);
    }

}



function  resetValue() {
    $("#roleName").val("");
    $("#roleRemark").val("");
    // $("#classMoney").val("");
}

function resetValueQZ() {
    $("#destroyNum").val("");
    $("#amountUp").val("");
    $("#amountDown").val("");
}

function resetValueZG() {
    $("#hyrs").val("");
    $("#bbj_dowm").val("");
    $("#bbj_up").val("");
    
}

function resetValueGW() {
    $("#bywcyj").val("");
    $("#yjdbbl").val("");
    // $("#bbj_up").val("");
    
}

function resetValueZXJL() {
    $("#yjdbbl_jl").val("");
    $("#yjze").val("")
    
}
