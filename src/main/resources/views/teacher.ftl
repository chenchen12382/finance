<!DOCTYPE html>
<html lang="en">

<#include "include/common.header.ftl">

<body data-type="widgets">
            <!-- 右侧内容 -->
            <!-- 菜单 -->
           <#include "include/common.menu.ftl">
        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">
            <div class="row-content am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title  am-cf">教师计费方案</div>


                            </div>
                            <div class="widget-body  am-fr">

                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                    <div class="am-form-group">
                                        <div class="am-btn-toolbar">
                                            <#--<div class="am-btn-group am-btn-group-xs">-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>-->
                                                <#--<button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>-->
                                            <#--</div>-->
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
                                        <input type="text" class="am-form-field " placeholder="开发中,无效">
                                        <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                                    </div>
                                </div>

                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-6">
                                    <div class="widget am-cf">
                                    <div class="widget-head am-cf">
                                        <div class="widget-title am-fl">亲子老师,Dookey ABC 助教</div>
                                        <div class="widget-function am-fr am-btn-group-xs">
                                          <button type="button" class="am-btn am-btn-default am-btn-success" id="add_btn" >  <span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="teacher_qz">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>销课人数起</th>
                                                <th>销课人数止</th>
                                                <th>课时费</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                                <#if parentingTeachers ?has_content>
                                                    <#list parentingTeachers as p>
                                                    <tr class="gradeX" id="">
                                                        <td>${p.id}</td>
                                                        <td>${p.offClassNumStart}</td>
                                                        <td>${p.offClassNumOver}</td>
                                                        <td>${p.classMoney}</td>
                                                        <td>
                                                            <div class="tpl-table-black-operation">
                                                                <a href="javascript:edit(${p.id});" >
                                                                    <i class="am-icon-pencil"></i> 编辑
                                                                </a>
                                                                <a href="javascript:remove(${p.id});" class="tpl-table-black-operation-del">
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
                                </div>

                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-6">
                                    <div class="widget am-cf">
                                        <div class="widget-head am-cf">
                                            <div class="widget-title am-fl">乐博士老师------亲子老师</div>
                                            <div class="widget-function am-fr am-btn-group-xs">
                                                <button type="button" class="am-btn am-btn-default am-btn-success" id="add_btn_lbs" onclick="add_lbs()">  <span class="am-icon-plus"></span> 新增</button>
                                            </div>
                                        </div>
                                        <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>等级</th>
                                                <th>每月消课人数</th>
                                                <th>课时费</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <#if lbsTeachers ?has_content>
                                                <#list lbsTeachers as lbs>
                                                <tr class="gradeX" id="">
                                                    <td>${lbs.id}</td>
                                                    <td>${lbs.level}</td>
                                                    <td>${lbs.offClassNum}</td>
                                                    <td>${lbs.classMoney}</td>
                                                    <td>
                                                        <div class="tpl-table-black-operation">
                                                            <a href="javascript:edit_lbs(${lbs.id});" >
                                                                <i class="am-icon-pencil"></i> 编辑
                                                            </a>
                                                            <a href="javascript:remove_lbs(${lbs.id});" class="tpl-table-black-operation-del">
                                                                <i class="am-icon-trash"></i> 删除
                                                            </a>
                                                        </div>
                                                    </td>
                                                </tr>
                                                </#list>

                                            </#if>

                                            <!-- more data -->
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


            <#--亲子老师,Dookey ABC 助教-->
            <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt" method="post">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">亲子老师,Dookey ABC 助教</div>
                    <div class="am-modal-bd">
                        <form class="am-form" id="qz_form">
                            <div class="am-form-group">
                                <label for="doc-ipt-email-1">销课人数起</label>
                                <input type="number" class="" id="offClassNumStart" name="offClassNumStart" placeholder="销课人数起" required/>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-email-1">销课人数止</label>
                                <input type="number" class="" id="offClassNumOver" name="offClassNumOver" placeholder="销课人数止" required/>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-email-1">课时费</label>
                                <input type="number" class="" id="classMoney" name="classMoney" placeholder="课时费" required/>
                            </div>
                        </form>

                    </div>
                    <div class="am-modal-footer">
                        <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                        <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                    </div>
                </div>
            </div>

            <#--乐博士-->
            <div class="am-modal am-modal-prompt" tabindex="-1" id="prompt_lbs" >
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">乐博士老师------亲子老师</div>
                    <div class="am-modal-bd">
                        <form class="am-form" id="lbs_form">
                            <div class="am-form-group">
                                <label for="doc-ipt-email-1">等级</label>
                                <input type="text" class="" id="level" name="level" placeholder="等级" required/>
                            </div>
                            <#--<div class="am-form-group">-->
                                <#--<label for="doc-ipt-email-1">销课人数</label>-->
                                <#--<input type="number" class="" id="offClassNum" name="offClassNum" placeholder="销课人数(按出勤人数算)" required/>-->
                            <#--</div>-->
                            <div class="am-form-group">
                                <label for="doc-ipt-email-1">课时费</label>
                                <input type="number" class="" id="classMoney_lbs" name="classMoney" placeholder="课时费" required/>
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
<script src="js/teacher.js"></script>
</html>