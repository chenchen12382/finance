<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

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
                                <div class="widget-title  am-cf">文章列表</div>


                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-2">
                                    <div class="am-form-group">
                                        <input type="text" id="s_name" minlength="3" placeholder="姓名" class="am-form-field" value="${query.name!''}"/>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-2">
                                    <div class="am-form-group">
                                        <input type="text" id="s_center" minlength="3" placeholder="中心" class="am-form-field" value="${query.center?default('')}" />
                                    </div>
                                </div>

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-2">
                                    <div class="am-form-group">
                                        <input type="text" id="s_start" minlength="3" placeholder="开始时间" class="am-form-field" value="${query.start?string("yyyy-MM-dd")}" data-am-datepicker />
                                    </div>
                                </div>




                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-2">
                                    <div class="am-input-group am-input-group-sm ">
                                        <#--<input type="text" class="am-form-field ">-->
                                            <input type="text" id="s_over" minlength="3" placeholder="结束时间" class="am-form-field" value="${query.over?string("yyyy-MM-dd")}" data-am-datepicker required/>
                                        <#--<input type="text" class="am-form-field ">-->
                                        <span class="am-input-group-btn">
                                            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"  id="s_btn"></button>
                                          </span>
                                    </div>
                                </div>

                                <div class=" am-scrollable-horizontal am-text-nowrap">
                                    <table width="100%" class="am-table am-table-striped am-table-bordered am-table-compact" id="example-r">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>姓名</th>
                                                <th>中心</th>
                                                <th>身份证号码</th>
                                                <th>职位</th>
                                                <th>基本工资</th>
                                                <th>岗位工资</th>
                                                <th>绩效工资</th>
                                                <th>保密费</th>
                                                <th>工资补差</th>
                                                <th>出勤天数</th>
                                                <th>工资调整补差</th>
                                                <th>饭贴</th>
                                                <th>津贴</th>
                                                <th>幼儿园补贴</th>
                                                <th>业绩/单位（元）</th>
                                                <th>消课数</th>
                                                <th>出差补贴</th>
                                                <th>绩效系数</th>
                                                <th>产假扣款</th>
                                                <th>事假扣款</th>
                                                <th>病假扣款</th>
                                                <th>旷工扣款</th>
                                                <th>迟到扣款</th>
                                                <th>其他扣款</th>
                                                <th>应发工资</th>
                                                <th>个人社保合计</th>
                                                <th>个人公积金</th>
                                                <th>个人所得税</th>
                                                <th>企业社保合计</th>
                                                <th>企业公积金</th>
                                                <th>实发工资</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <#if computes ?has_content>
                                            <#list computes as c>
                                            <tr class="gradeX" id="">
                                                <td>${(page.getPage()-1)*10+(c_index+1)}</td>
                                                <td>${c.name!""}</td>
                                                <td>${c.center!""}</td>
                                                <td>${c.sfz!0}</td>
                                                <td>${c.work!''}</td>
                                                <td>${c.dx!0}</td>
                                                <td>${c.gwgz!0}</td>
                                                <td>${c.jxgz!0}</td>
                                                <td>${c.bmf!0}</td>
                                                <td>${c.gzbc!0}</td>
                                                <td>${c.cqts!0}</td>
                                                <td>${c.bfgz!0}</td>
                                                <td>${c.ft!0}</td>
                                                <td>${c.jt!0}</td>
                                                <td>${c.yeybt!0}</td>
                                                <td>${c.yjtc!0}</td>
                                                <td>${c.xkrs!0}</td>
                                                <td>${c.ccbt!0}</td>
                                                <td>${c.jxxs!0}</td>
                                                <td>${c.cjkk!0}</td>
                                                <td>${c.sjkk!0}</td>
                                                <td>${c.bjkk!0}</td>
                                                <td>${c.kgkk!0}</td>
                                                <td>${c.cdkk!0}</td>
                                                <td>${c.qtkk!0}</td>
                                                <td>${c.yfgz!0}</td>
                                                <td>${c.grsbhj!0}</td>
                                                <td>${c.grgjj!0}</td>
                                                <td>${c.grsds!0}</td>
                                                <td>${c.qysbhj!0}</td>
                                                <td>${c.qygjj!0}</td>
                                                <td>${c.gzze!0}</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:remove(${c.id});" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="am-u-lg-12 am-cf">
                                    <div id="page">
                                  <#if page ?has_content>

                                    <#assign p=page.getPage()>
                                    <#assign total=page.getTotalPages()>
                                        <ul class="am-pagination am-pagination-centered">
                                        <#if p==1>
                                            <li class="am-disabled"><a href="#">上一页</a></li>
                                        <#else >
                                            <li ><a href="?page=${p-1}">上一页</a></li>
                                        </#if>

                                        <#if p?has_content  >
                                            <#if p - 2 &gt;= 1>
                                                <li class=><a href="?page=${page.getPage()-2}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">${page.getPage()-2}</a></li>
                                            </#if>
                                            <#if page.hasPrePage>
                                                <li class=><a href="?page=${page.getPage()-1}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">${page.getPage()-1}</a></li>
                                            </#if>
                                            <li class="am-active"><a href="?page=${page.getPage()}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">${page.getPage()}</a></li>
                                            <#if page.hasNextPage>
                                                <li ><a href="?page=${page.getPage()+1}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">${page.getPage()+1}</a></li>
                                            </#if>
                                            <#if p + 2 <= total>
                                                <li ><a href="?page=${page.getPage()+2}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">${page.getPage()+2}</a></li>
                                            </#if>
                                        </#if>

                                        <#if page.getPage()==page.getTotalPages()>
                                            <li class="am-disabled"><a href="#">下一页</a></li>
                                        <#else >
                                            <li><a href="?page=${page.getPage()+1}&name=${query.name!''}&center=${query.center!''}&start=${query.start?string("yyyy-MM-dd")}&over=${query.over?string("yyyy-MM-dd")}">下一页</a></li>
                                        </#if>
                                        </ul>

                                  </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<#--角色管理-->
<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt" >
    <div class="am-modal-dialog">
        <div class="am-modal-hd">员工管理</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">员工姓名</label>
                    <input type="text" class="" id="name" name="name" placeholder="员工姓名"  required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">中心</label></br>
                    <select id="center" data-am-selected="{btnWidth: '100%',searchBox: 1, btnStyle: 'primary',maxHeight: 200}" >
                        <option value="">-=请选择一项=-</option>
                        <#if centers ?has_content>
                            <#list centers as center>
                                <option value="${center.center}">${center.center}</option>
                            </#list>
                        </#if>
                        <#--<option value="option1">选项一...</option>-->
                        <#--<option value="option2">选项二.....</option>-->
                        <#--<option value="option3">选项三........</option>-->
                    </select>
                    <#--<input type="number" class="" id="roleRemark" name="roleRemark" placeholder="中心" />-->
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">员工职位</label></br>
                    <select id="position" data-am-selected="{btnWidth: '100%',searchBox: 1, btnStyle: 'secondary',maxHeight: 200}" >
                    <#if roles ?has_content>
                        <option value="">-=请选择一项=-</option>
                        <#list roles as role>
                            <option value="${role.roleName}">${role.roleName}</option>
                        </#list>
                    </#if>
                    </select>
                <#--<input type="number" class="" id="roleRemark" name="roleRemark" placeholder="中心" />-->
                </div>
            </form>

        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<#include "include/common.footer.ftl">
</body>
<script src="js/compute.form.js"></script>

</html>