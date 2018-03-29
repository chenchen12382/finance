package com.pz.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.pz.base.AssertUtil;
import com.pz.base.BaseQuery;
import com.pz.dao.ComputeDao;
import com.pz.dao.TeacherDao;
import com.pz.dto.ComputeFormQuery;
import com.pz.exception.ParamException;
import com.pz.model.Compute;
import com.pz.model.LbsTeacher;
import com.pz.model.ParentingTeacher;
import com.pz.utils.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/3/8.
 */
@Service
public class ComputeService {

    @Autowired
    private ComputeDao computeDao;

    @Autowired
    private TeacherDao teacherDao;



    public static void chickParam(Compute compute){
        AssertUtil.intIsNotEmpty(compute.getDx(),"请输入基本薪资！");

        //薪资计算
        AssertUtil.isNotEmpty(compute.getName(),"请选择员工！");

        AssertUtil.isNotEmpty(compute.getSfz(),"请输入身份证号！");
    }


    public void insert(Compute compute) {




        chickParam(compute);




//       Integer dx =  compute.getDx();
//        Integer gwgz =  compute.getGwgz();
//        if(gwgz==null){
//            gwgz=0;
//            compute.setGwgz(0);
//        }
//        Integer jxgz =  compute.getJxgz();
//        if(jxgz==null){
//            jxgz=0;
//            compute.setJxgz(0);
//        }
//        Integer bmf =  compute.getBmf();
//        if(bmf==null){
//            bmf=0;
//            compute.setBmf(0);
//        }
//        Double tcjj =  compute.getTcjj();
//        if(tcjj==null){
//            tcjj=0.0;
//            compute.setTcjj(0.0);
//        }
//        Integer bbj =  compute.getBbj();
//        if(bbj==null){
//            bbj=0;
//            compute.setBbj(0);
//        }
//        Integer ksf =   compute.getKsf();
//        if(ksf==null){
//            ksf=0;
//            compute.setKsf(0);
//        }
//        Integer bfgz =  compute.getBfgz();
//        if(bfgz==null){
//            bfgz=0;
//            compute.setBfgz(0);
//        }
//        Integer ft =   compute.getFt();
//        if(ft==null){
//            ft=0;
//            compute.setFt(0);
//        }
//        Integer jt =   compute.getJt();
//        if(jt==null){
//            jt=0;
//            compute.setJt(0);
//        }
//        Integer bsj =    compute.getBsj();
//        if(bsj==null){
//            bsj=0;
//            compute.setBsj(0);
//        }
//        Integer kk =   compute.getKk();
//        if(kk==null){
//            kk=0;
//            compute.setKk(0);
//        }
//        Integer qtkk =   compute.getQtkk();
//        if(qtkk==null){
//            qtkk=0;
//            compute.setQtkk(0);
//        }
//
//
//        double count = dx+gwgz+jxgz+bmf+tcjj+bbj+ksf+bfgz+ft+jt-bsj-kk-qtkk;
//        System.out.println(count);
//
//        compute.setGzze(Double.valueOf(count));

        computeDao.insert(compute);



    }

    public PageList<Compute> selectForPage(ComputeFormQuery query) {

        buildTime(query);

        PageList<Compute> computes = computeDao.selectForPage(query,query.buildPageBounds());

        return computes;

    }


    /**
     * 构建时间

     */
    private void buildTime(ComputeFormQuery query){
        Date start = query.getStart();
        Date over = query.getOver();
        if(start==null && over==null ){
            start= DateUtil.getFisrtDayOfNow();
            over = DateUtil.getLastDayOfDate(new Date());

        }

        if(start!=null && over==null){
            over=DateUtil.getLastDayOfDate(new Date());
        }

        if(start==null && over!=null){
            throw new ParamException("请输入开始时间");
        }

        query.setStart(start);
        query.setOver(over);

    }


    public void delete(Integer id) {

        computeDao.delete(id);

    }

    /**
     * 批量导入excel
     * @param upExl
     */
    public void readExcel(MultipartFile upExl) {


        Date start = DateUtil.getFisrtDayOfNow();
        Date over = DateUtil.getLastDayOfDate(new Date());
        Compute compute=new Compute();
        HSSFWorkbook workbook = null;
        List<Compute> computes = new ArrayList<>();
//        Integer centerId = protocolNum.getCenterId();
        try {

            if (upExl != null) {
                workbook = new HSSFWorkbook(upExl.getInputStream());
//            workbook = new HSSFWorkbook(new FileInputStream(new File("E:/2.xls")));
                HSSFSheet sheet = workbook.getSheetAt(0);
//            List<ProtocolNum> xybh = new ArrayList<>();

//            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 获取每个Sheet表
//                sheet = workbook.getSheetAt(i);
                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {// getLastRowNum，获取最后一行的行标
                    HSSFRow row = sheet.getRow(i);
                    compute = new Compute();
                    if (row != null) {
                        for (int j = 0; j < row.getLastCellNum(); j++) {// getLastCellNum，是获取最后一个不为空的列是第几个
                            if (row.getCell(j) != null) { // getCell 获取单元格数据
//                                System.out.print(row.getCell(k) + "\t");

                                HSSFCell excelRead = row.getCell(j);
                                excelRead.setCellType(HSSFCell.CELL_TYPE_STRING);
                                String cellValue = excelRead.getStringCellValue();
//                                if(cellValue.length()!=13){
//                                    throw new ParamException("协议编号"+cellValue +" 不是13位  请检查");
//                                }
//                                Pattern pattern = Pattern.compile("PZ[0-9]{11}");
//                                if(!pattern.matcher(cellValue).matches()){
//                                    throw new ParamException("只能以大写PZ开头并包含11位数字,不能包含其它符号");
//                                }
                                //中心名称
                                if(j==0){
                                    compute.setCenter(cellValue);
                                }
                                // 	中文名
                                if(j==1){
                                    compute.setName(cellValue);
                                }
                                // 身份证号码
                                if(j==2){
                                    compute.setSfz(cellValue);
                                }
                                // 	职位
                                if(j==3){
                                    compute.setWork(cellValue);
                                }
                                // 基本工资
                                if(j==4){
                                    compute.setDx(Integer.valueOf(cellValue));
                                }
                                // 岗位工资
                                if(j==5){
                                    compute.setGwgz(Integer.valueOf(cellValue));
                                }

                                // 绩效工资
                                if(j==6){
                                    compute.setJxgz(Integer.valueOf(cellValue));
                                }
                                // 保密费	工资补差（业绩底薪考核）
                                if(j==7){
                                    compute.setBmf(Integer.valueOf(cellValue));
                                }

//                                工资补差（业绩底薪考核）
                                if(j==8){
                                    compute.setGzbc(Integer.valueOf(cellValue));
                                }

                                // 出勤天数
                                if(j==9){
                                    compute.setCqts(Integer.valueOf(cellValue));
                                }

                                // 工资调整补差（应补应扣）
                                if(j==10){
                                    compute.setBfgz(Integer.valueOf(cellValue));
                                }
                                // 	饭贴
                                if(j==11){
                                    compute.setFt(Integer.valueOf(cellValue));
                                }
                                // 	津贴
                                if(j==12){
                                    compute.setJt(Integer.valueOf(cellValue));
                                }
                                // 	幼儿园补贴
                                if(j==13){
                                    compute.setYeybt(Integer.valueOf(cellValue));
                                }

                                // 	提成奖金   业绩/单位（元）
                                if(j==14){
                                    compute.setYjtc(Integer.valueOf(cellValue));
                                }

                                // 	课时费    消课人数
                                if(j==15){
                                    compute.setXkrs(Integer.valueOf(cellValue));
                                }

                                // 出差补贴
                                if(j==16){
                                    compute.setCcbt(Integer.valueOf(cellValue));
                                }


                                // 绩效系数
                                if(j==17){
                                    compute.setJxxs(Double.valueOf(cellValue));
                                }
                                // 产假扣款

                                if(j==18){

                                    compute.setCjkk(Double.valueOf(cellValue));
                                }

                                // 事假扣款

                                if(j==19){
                                    compute.setSjkk(Double.valueOf(cellValue));

                                }
                                // 病假扣款
                                if(j==20){

                                    compute.setBjkk(Double.valueOf(cellValue));
                                }

                                // 旷工扣款
                                if(j==21){

                                    compute.setKgkk(Double.valueOf(cellValue));
                                }

                                // 迟到扣款
                                if(j==22){

                                    compute.setCdkk(Double.valueOf(cellValue));

                                }


                                // 其他扣款
                                if(j==23){

                                    compute.setQtkk(Integer.valueOf(cellValue));
                                }

                                // 应发工资
                                if(j==24){
                                    compute.setYfgz(Double.valueOf(cellValue));
                                }


                                // 个人社保合计
                                if(j==25){
                                    compute.setGrsbhj(Double.valueOf(cellValue));
                                }


                                // 	个人公积金
                                if(j==26){
                                    compute.setGrgjj(Double.valueOf(cellValue));
                                }


                                // 个人所得税

                                if(j==27){

                                    compute.setGrsds(Double.valueOf(cellValue));

                                }
                                // 	企业社保合计
                                if(j==28){

                                    compute.setQysbhj(Double.valueOf(cellValue));
                                }

                                // 	企业公积金
                                if(j==29){
                                    compute.setQygjj(Double.valueOf(cellValue));

                                }

                                // 实发工资
                                if(j==30){
                                    compute.setGzze(Double.valueOf(cellValue));
                                }

                            }
                        }

                        //查询是否重复
                        String sfz = compute.getSfz();
                        Integer count=computeDao.findBySfz(sfz,start,over);

                        //判断计算提成

                        Integer yjtc = compute.getYjtc();
                        Integer xkrs = compute.getXkrs();
                        String work = compute.getWork();

                        if(yjtc!=null){

                            //有提成  //顾问
                            if(work.trim().contains("顾问")){

                                if(yjtc>=60000&&yjtc<110000){
                                    compute.setTcjj(yjtc*0.02);

                                }

                                if(yjtc>=110000&& yjtc<160000){
                                    compute.setTcjj(yjtc*0.03);
                                }

                                if(yjtc>=160000&& yjtc<9999999){
                                    compute.setTcjj(yjtc*0.04);
                                }

                            }

                        }


                        if (xkrs!=null){
                            //教师

                            if(work.trim().contains("教师")||work.trim().contains("助教")||work.trim().contains("乐博士")||work.trim().contains("启稚")){

                                if(work.trim().equals("亲子教师") || work.trim().equals("Dooky ABC助教")){

                                    List<ParentingTeacher> parentingTeachers = teacherDao.selectForPage();

                                    for(int k=0;k<parentingTeachers.size();k++)
                                    {
                                        if(xkrs>=parentingTeachers.get(k).getOffClassNumStart()&&xkrs<parentingTeachers.get(k).getOffClassNumOver()){

                                            compute.setBbj(xkrs*parentingTeachers.get(k).getClassMoney());
                                        }
                                    }


                                }else {

                                    String tempWork ;

                                     if (work.trim().contains("助教")){
                                        tempWork="助教";
                                     }

                                    else  {
                                        tempWork="主教";
                                    }


                                     Integer ksf = teacherDao.findByTemp(tempWork);



                                    compute.setBbj(xkrs*ksf);

                                }
                            }

                        }



//                        if(count>0){
//                            compute.setStart(start);
//                            compute.setOver(over);
//                            computeDao.update(compute);
//                        }else {
//                            computeDao.insert(compute);
//                        }

                        judge(compute,start,over,count);

                    }
                }
            }else{
                throw  new ParamException("参数错误，请联系管理员！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParamException("文件有误,只能上传xls格式的excel文件!");

        }


    }


    /**
     * 计算footer
     * @return
     * @param query
     */
    public Compute findCount(ComputeFormQuery query) {

        Compute compute=  computeDao.findCount(query);
        return compute;
    }

    public void add(Compute compute) {

        computeDao.insert(compute);

    }


    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Compute selectForId(Integer id) {
        Compute compute = computeDao.selectForId(id);
        return compute;
    }

    public void update(Compute compute) {

        chickParam(compute);


//        Date start = DateUtil.getFisrtDayOfNow();
//        Date over = DateUtil.getLastDayOfDate(new Date());
//
//
//        String sfz = compute.getSfz();
//        Integer count=computeDao.findBySfz(sfz,start,over);
//
//
////        if(count>0){
////            compute.setStart(start);
////            compute.setOver(over);
////            computeDao.update(compute);
////        }else {
////            computeDao.insert(compute);
////        }
//        if(count>0){
//            compute.setStart(start);
//            compute.setOver(over);
//            computeDao.update(compute);
//        }else {
//            computeDao.insertForId(compute);
//        }

        computeDao.updateForId(compute);

    }


    /**
     * 判断是插入还是修改
     *
     * @param compute
     * @param start
     * @param over
     * @param count
     */
    private void judge(Compute compute, Date start, Date over, Integer count){

        if(count>0){
            compute.setStart(start);
            compute.setOver(over);
            computeDao.update(compute);
        }else {
            computeDao.insert(compute);
        }


    }


}

