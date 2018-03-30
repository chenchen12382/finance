<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<#setting number_format="0.##">
<#include "include/common.header.ftl">

<body data-type="widgets">
<#include "include/common.menu.ftl">

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
          

            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">薪酬计算</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">
                      <#if compute ?has_content>

                                <form class="am-form tpl-form-line-form"  id="add_form">
                                    <h2 style="text-align:center">基本信息</h2>
                                    <input type="hidden" id="f_id" value="${compute.getId()!''}">

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">中心名称:</label>
                                        <div class="am-u-sm-2">
                                            <input type="text" class="tpl-form-input" id="f_center" name="center" value="${compute.getCenter()!""}" placeholder="请输入中心名称">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">姓名:</label>
                                        <div class="am-u-sm-2">
                                            <input type="text" class="tpl-form-input" id="f_name" value="${compute.getName()!""}" name="name" placeholder="请输入姓名">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">身份证号码:</label>
                                        <div class="am-u-sm-2">
                                            <input type="text" class="tpl-form-input" id="f_sfz" value="${compute.getSfz()!""}" name="sfz" placeholder="请输入身份证号码">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">职位: </label>
                                        <div class="am-u-sm-2">
                                            <input type="text" class="tpl-form-input" id="f_work" name="work" value="${compute.getWork()!''}" placeholder="请输入职位">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>




                                    <h2 style="text-align:center">应发项目</h2>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">基本工资: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_dx" name="dx" value="${compute.getDx()!''}"  placeholder="请输入基本工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">岗位工资: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_gwgz" name="gwgz" value="${compute.getGwgz()!''}" placeholder="请输入岗位工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">绩效工资:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_jxgz" name="jxgz" value="${compute.getJxgz()!''}" placeholder="请输入绩效工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">保密费: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_bmf" name="bmf" value="${compute.getBmf()!''}" placeholder="请输入保密费">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">工资补差: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_gzbc" name="gzbc" value="${compute.getGzbc()!''}" placeholder="请输入工资补差">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">出勤天数:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_cqts" name="cqts" value="${compute.getCqts()!''}" placeholder="请输入出勤天数">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">工资调整补差: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_bfgz" name="bfgz" value="${compute.getBfgz()!''}" placeholder="请输入工资调整补差">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">饭贴:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_ft" name="ft" value="${compute.getFt()!''}" placeholder="请输入饭贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">津贴: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_jt" name="jt" value="${compute.getJt()!''}" placeholder="请输入津贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">幼儿园补贴: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_yeybt" name="yeybt" value="${compute.getYeybt()!''}" placeholder="请输入幼儿园补贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">提成奖金: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_tcjj" name="tcjj" value="${compute.getTcjj()!''}" placeholder="请输入提成奖金">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">课时费: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_bbj" name="bbj" value="${compute.getBbj()!''}" placeholder="请输入课时费">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">出差补贴: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_ccbt" name="ccbt" value="${compute.getCcbt()!''}" placeholder="请输入出差补贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">绩效系数: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_jxxs" name="jxxs" value="${compute.getJxxs()!''}" placeholder="请输入绩效系数">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label"></label>
                                        <div class="am-u-sm-2">
                                            <#--<input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入幼儿园补贴">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label"></label>
                                        <div class="am-u-sm-2">
                                            <#--<input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入幼儿园补贴">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>








                                    <h2 style="text-align:center">应扣项目</h2>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">产假扣款:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_cjkk" name="cjkk" value="${compute.getCjkk()!''}" placeholder="请输入产假扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">事假扣款:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_sjkk" name="sjkk" value="${compute.getSjkk()!''}" placeholder="请输入事假扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">病假扣款: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_bjkk" name="bjkk" value="${compute.getBjkk()!''}" placeholder="请输入病假扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">旷工扣款: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_kgkk" name="kgkk" value="${compute.getKgkk()!''}" placeholder="请输入旷工扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">迟到扣款: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_cdkk" name="cdkk" value="${compute.getCdkk()!''}" placeholder="请输入迟到扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">其他扣款:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_qtkk" name="qtkk" value="${compute.getQtkk()!''}" placeholder="请输入其他扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label"></label>
                                        <div class="am-u-sm-2">
                                        <#--<input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入幼儿园补贴">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label"></label>
                                        <div class="am-u-sm-2">
                                        <#--<input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入幼儿园补贴">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>


                                    <h2 style="text-align:center">社保及工资</h2>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">应发工资: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_yfgz" name="yfgz" value="${compute.getYfgz()!''}" placeholder="请输入应发工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">个人社保合计: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_grsbhj" name="grsbhj" value="${compute.getGrsbhj()!''}" placeholder="请输入个人社保合计">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">个人公积金:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_grgjj" name="grgjj" value="${compute.getGrgjj()!''}" placeholder="请输入个人公积金">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">个人所得税:</label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_grsds" name="grsds" value="${compute.getGrsds()!''}" placeholder="请输入个人所得税">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-1 am-form-label">企业社保合计: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_qysbhj" name="qysbhj" value="${compute.getQysbhj()!''}" placeholder="请输入企业社保合计">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">企业公积金: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_qygjj" name="qygjj" value="${compute.getQygjj()!''}" placeholder="请输入企业公积金">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label">实发工资: </label>
                                        <div class="am-u-sm-2">
                                            <input type="number" class="tpl-form-input" id="f_gzze" name="gzze" value="${compute.getGzze()!''}" placeholder="请输入实发工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-1 am-form-label"></label>
                                        <div class="am-u-sm-2">
                                            <#--<input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入绩效工资">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>

                                    </div>


                                    <br />
                                    <hr />
                                    <br />
                                    <div class="am-form-group">
                                        <div class="am-u-sm-6 am-u-sm-push-6">
                                            <button type="button" class="am-btn am-btn-primary tpl-btn-bg-color-success " id="add_btn">提交</button>
                                        </div>
                                    </div>
                                </form>
                      </#if>
                            </div>
                        </div>
                    </div>
                </div>

        </div>
    </div>
    </div>

<#--教师计费方案-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt-1" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">教师计费方案</div>
        <div class="am-modal-bd">
            <form class="am-form" id="teacher_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">每月消课人数</label>
                    <input type="number" class="" id="destroyNum" name="destroyNum" placeholder="每月消课人数" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">报班金额8000以上次数</label>
                    <input type="number" class="" id="amountUp" name="amountUp" placeholder="备注" />
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">报班金额8000以下次数</label>
                    <input type="number" class="" id="amountDown" name="amountDown" placeholder="备注" />
                </div>
            </form>
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<#--课程顾问提成-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt-2" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">课程顾问提成</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">本月完成业绩</label>
                    <input type="number" class="" id="bywcyj" name="bywcyj" placeholder="本月完成业绩" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">业绩达标比例(填写百分比1-100数字)</label>
                    <input type="number" class="" id="yjdbbl" name="yjdbbl" placeholder="业绩达标比例" required/>
                </div>
            </form>

        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<#--教学主管薪酬方案-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt-3" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">教学主管薪酬方案</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">消课奖提成方案(会员人数)</label>
                    <input type="number" class="" id="hyrs" name="roleName" placeholder="会员人数" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">报班奖8000及以下（不含乐博士课程）</label>
                    <input type="number" class="" id="bbj_dowm" name="roleRemark" placeholder="次数" />
                </div>

                <div class="am-form-group">
                    <label for="doc-ipt-email-1">报班奖8000以上（不含乐博士课程）</label>
                    <input type="number" class="" id="bbj_up" name="roleRemark" placeholder="次数" />
                </div>
            </form>

        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<#--中心经理提成方案-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt-4" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">中心经理提成方案</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">业绩达标比例</label>
                    <input type="text" class="" id="yjdbbl_jl" name="yjdbbl" placeholder="只能填写60-200之间的数字,为百分比" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">业绩总额,单位/万元</label>
                    <input type="text" class="" id="yjze" name="yjze" placeholder="超过100达标比例填写,单位: 万元" />
                </div>
            </form>

        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>


<#--中心经理提成方案-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt-import" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">批量上传</div>
        <div class="am-modal-bd">
            <form class="am-form" id="import_form">
                <div class="am-form-group">
                    <div class="am-form-group am-form-file">
                        <button type="button" class="am-btn am-btn-danger am-btn-sm">
                            <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                        <input id="doc-form-file" name="upExl" type="file" multiple>
                    </div>
                    <div id="file-list"></div>
                </div>
            </form>

        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<script src="js/compute.js"></script>
<#include "include/common.footer.ftl">

</body>

</html>