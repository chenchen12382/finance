<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<#include "include/common.header.ftl">

<body data-type="widgets">
<#include "include/common.menu.ftl">

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <#--<div class="container-fluid am-cf">-->
                <#--&lt;#&ndash;<div class="row">&ndash;&gt;-->
                    <#--&lt;#&ndash;<div class="am-u-sm-12 am-u-md-12 am-u-lg-9">&ndash;&gt;-->
                        <#--&lt;#&ndash;<div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 薪酬计算工具 </div>&ndash;&gt;-->
                        <#--&lt;#&ndash;<p class="page-header-description">薪酬计算工具。</p>&ndash;&gt;-->
                    <#--&lt;#&ndash;</div>&ndash;&gt;-->
                    <#--&lt;#&ndash;<div class="am-u-lg-3 tpl-index-settings-button">&ndash;&gt;-->
                        <#--&lt;#&ndash;<button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> </button>&ndash;&gt;-->
                    <#--&lt;#&ndash;</div>&ndash;&gt;-->
                <#--&lt;#&ndash;</div>&ndash;&gt;-->

            <#--</div>-->

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

                                <form class="am-form tpl-form-line-form" >

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-2 am-form-label">姓名: <span class="tpl-form-line-small-title">name</span></label>
                                        <div class="am-u-sm-10">
                                            <select data-am-selected="{searchBox: 1}" style="display: none;" id="select_name">
                                                <option value="">-=请选择一项=-</option>
                                            <#if employees ?has_content>
                                                <#list employees as employee>
                                                    <option value="${employee.name},${employee.position},${employee.center}">${employee.name}--${employee.position}--${employee.center}</option>
                                                </#list>
                                            </#if>
                                            </select>
                                               &nbsp;&nbsp;&nbsp;&nbsp; <button type="button" id="compute_btn" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提成计算</button>
                                        </div>
                                    </div>
                                    <h2 style="text-align:center">应发项目</h2>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">底薪: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_dx" placeholder="">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label"> <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-4">
                                            <#--<input type="text" class="tpl-form-input" id="user-name" placeholder="请输入绩效系数">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">岗位工资: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_gwgz" placeholder="请输入岗位工资">
                                            <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label">绩效工资: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_jxgz" placeholder="请输入绩效工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">保密费: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_bmf" placeholder="请输入保密费">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label">提成奖金: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_tcjj" placeholder="请输入提成奖金">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">报/续班奖金: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_bbj" placeholder="请输入报/续班奖金">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label">课时费: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_ksf" placeholder="请输入课时费">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">补发工资: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_bfgz" placeholder="请输入补发工资">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label">饭贴: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_ft" placeholder="请输入饭贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">津贴: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_jt" placeholder="请输入津贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label"> </label>
                                        <div class="am-u-sm-4">
                                            <#--<input type="number" class="tpl-form-input" id="user-name" placeholder="请输入绩效系数">-->
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>


                                    <h2 style="text-align:center">应扣项目</h2>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">病事假: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_bsj" placeholder="请输入津贴">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label">迟到/忘打卡扣款: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_kk" placeholder="请输入迟到/忘打卡扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-2 am-form-label">其他扣款: <span class="tpl-form-line-small-title">Title</span></label>
                                        <div class="am-u-sm-4">
                                            <input type="number" class="tpl-form-input" id="f_qtkk" placeholder="请输入其他扣款">
                                        <#--<small>请填写标题文字10-20字左右。</small>-->
                                        </div>
                                        <label for="user-name" class="am-u-sm-2 am-form-label"> </label>
                                        <div class="am-u-sm-4">
                                            <#--<input type="text" class="tpl-form-input" id="user-name" placeholder="请输入迟到/忘打卡扣款">-->
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
                    <input type="text" class="" id="bbj_dowm" name="roleRemark" placeholder="次数" />
                </div>

                <div class="am-form-group">
                    <label for="doc-ipt-email-1">报班奖8000以上（不含乐博士课程）</label>
                    <input type="text" class="" id="bbj_up" name="roleRemark" placeholder="次数" />
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

<script src="js/compute.js"></script>
<#include "include/common.footer.ftl">

</body>

</html>