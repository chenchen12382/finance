<!DOCTYPE html>
<html lang="en">

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
                                <div class="widget-title  am-cf">角色列表</div>


                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-success" id="add_btn"><span class="am-icon-plus"></span> 新增</button>
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <#--    <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select data-am-selected="{btnSize: 'sm'}">
              <#--<option value="option1">所有类别</option>
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
                                       <#-- <input type="text" class="am-form-field ">
                                        <span class="am-input-group-btn">
             <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>-->
          </span>
                                    </div>
                                </div>

                                <div class="am-u-sm-12">
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>职位</th>
                                                <th>备注</th>
                                                <th>更新时间</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <#if roles ?has_content>
                                            <#list roles as r>
                                            <tr class="gradeX" id="">
                                                <td>${(page.getPage()-1)*10+(r_index+1)}</td>
                                                <td>${r.roleName}</td>
                                                <td>${r.roleRemark?default("")}</td>
                                                <td>${r.updateDate?date}</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:edit(${r.id});" >
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
                                                        <a href="javascript:remove(${r.id});" class="tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            </#list>

                                        </#if>

                                            <#--<tr class="gradeX">-->
                                                <#--<td>Amaze UI 模式窗口</td>-->
                                                <#--<td>张鹏飞</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->
                                            <#--<tr class="even gradeC">-->
                                                <#--<td>有适配微信小程序的计划吗</td>-->
                                                <#--<td>天纵之人</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->
                                            <#--<tr class="gradeX">-->
                                                <#--<td>请问有没有amazeui 分享插件</td>-->
                                                <#--<td>王宽师</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->
                                            <#--<tr class="even gradeC">-->
                                                <#--<td>关于input输入框的问题</td>-->
                                                <#--<td>着迷</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->
                                            <#--<tr class="even gradeC">-->
                                                <#--<td>有没有发现官网上的下载包不好用</td>-->
                                                <#--<td>醉里挑灯看键</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->

                                            <#--<tr class="even gradeC">-->
                                                <#--<td>我建议WEB版本文件引入问题</td>-->
                                                <#--<td>罢了</td>-->
                                                <#--<td>2016-09-26</td>-->
                                                <#--<td>-->
                                                    <#--<div class="tpl-table-black-operation">-->
                                                        <#--<a href="javascript:;">-->
                                                            <#--<i class="am-icon-pencil"></i> 编辑-->
                                                        <#--</a>-->
                                                        <#--<a href="javascript:;" class="tpl-table-black-operation-del">-->
                                                            <#--<i class="am-icon-trash"></i> 删除-->
                                                        <#--</a>-->
                                                    <#--</div>-->
                                                <#--</td>-->
                                            <#--</tr>-->
                                            <!-- more data -->


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
        <div class="am-modal-hd">角色管理</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">职位</label>
                    <input type="text" class="" id="roleName" name="roleName" placeholder="职位" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">备注</label>
                    <input type="text" class="" id="roleRemark" name="roleRemark" placeholder="备注" />
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
<script src="js/role.js"></script>

</html>