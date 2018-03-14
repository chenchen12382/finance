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

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-success" id="add_btn"><span class="am-icon-plus"></span> 新增</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select data-am-selected="{btnSize: 'sm'}">
              <option value="option1">所有类别</option>
              <#--<option value="option2">IT业界</option>-->
              <#--<option value="option3">数码产品</option>-->
              <#--<option value="option3">笔记本电脑</option>-->
              <#--<option value="option3">平板电脑</option>-->
              <#--<option value="option3">只能手机</option>-->
              <#--<option value="option3">超极本</option>-->
            </select>
                                    </div>
                                </div>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                        <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                                    </div>
                                </div>

                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>姓名</th>
                                                <th>中心</th>
                                                <th>工资总额</th>
                                                <th>基本工资</th>
                                                <th>岗位工资</th>
                                                <th>绩效工资</th>
                                                <th>保密费</th>
                                                <th>提成奖金</th>
                                                <th>报/续班奖金</th>
                                                <th>课时费</th>
                                                <th>补发工资</th>
                                                <th>饭贴</th>
                                                <th>津贴</th>
                                                <th>病事假</th>
                                                <th>迟到/忘打卡扣款</th>
                                                <th>其他扣款</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <#if computes ?has_content>
                                            <#list computes as c>
                                            <tr class="gradeX" id="">
                                                <td>${(page.getPage()-1)*10+(c_index+1)}</td>
                                                <td>${c.name}</td>
                                                <td>${c.center}</td>
                                                <td>${c.gzze}</td>
                                                <td>${c.dx}</td>
                                                <td>${c.gwgz}</td>
                                                <td>${c.jxgz}</td>
                                                <td>${c.bmf}</td>
                                                <td>${c.tcjj}</td>
                                                <td>${c.bbj}</td>
                                                <td>${c.ksf}</td>
                                                <td>${c.bfgz}</td>
                                                <td>${c.ft}</td>
                                                <td>${c.jt}</td>
                                                <td>${c.bsj}</td>
                                                <td>${c.kk}</td>
                                                <td>${c.qtkk}</td>
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
                                                <li class=><a href="?page=${page.getPage()-2}">${page.getPage()-2}</a></li>
                                            </#if>
                                            <#if page.hasPrePage>
                                                <li class=><a href="?page=${page.getPage()-1}">${page.getPage()-1}</a></li>
                                            </#if>
                                            <li class="am-active"><a href="?page=${page.getPage()}">${page.getPage()}</a></li>
                                            <#if page.hasNextPage>
                                                <li ><a href="?page=${page.getPage()+1}">${page.getPage()+1}</a></li>
                                            </#if>
                                            <#if p + 2 <= total>
                                                <li ><a href="?page=${page.getPage()+2}">${page.getPage()+2}</a></li>
                                            </#if>
                                        </#if>

                                        <#if page.getPage()==page.getTotalPages()>
                                            <li class="am-disabled"><a href="#">下一页</a></li>
                                        <#else >
                                            <li><a href="?page=${page.getPage()+1}">下一页</a></li>
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
<script src="js/compute.js"></script>

</html>