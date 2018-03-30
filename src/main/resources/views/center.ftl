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
                                <div class="widget-title  am-cf">中心管理</div>


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
                               <#-- <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                    <div class="am-form-group tpl-table-list-select">
                                        <select data-am-selected="{btnSize: 'sm'}">
              <option value="option1">所有类别</option>-->
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
                                    <#--    <input type="text" class="am-form-field ">
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
                                                <th>中心</th>
                                                <th>区域</th>
                                                <th>更新时间</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <#if centers ?has_content>
                                            <#list centers as c>
                                            <tr class="gradeX" id="">
                                                <#if page?has_content>
                                                    <td>${(page.getPage()-1)*10+(c_index+1)}</td>
                                                </#if>
                                                <td>${c.center}</td>
                                                <td>${c.district}</td>
                                                <td>${c.updateDate?date}</td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:edit(${c.id});" >
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
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
        <div class="am-modal-hd">中心管理</div>
        <div class="am-modal-bd">
            <form class="am-form" id="role_form">
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">中心</label>
                    <input type="text" class="" id="center" name="center" placeholder="中心" required/>
                </div>
                <div class="am-form-group">
                    <label for="doc-ipt-email-1">区域</label>
                    <input type="text" class="" id="district" name="district" placeholder="区域" />
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
<script src="js/center.js"></script>

</html>