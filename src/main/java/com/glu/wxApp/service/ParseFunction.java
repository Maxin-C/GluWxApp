package com.glu.wxApp.service;

import com.glu.wxApp.domain.*;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParseFunction {

    public Map parseToMap(String info){
        Gson gson = new Gson();
        Map map = new HashMap<String, String>();
        map = gson.fromJson(info, map.getClass());
        return map;
    }

    public DoctorChat parseToDoctorChat(String info, boolean flag) throws ParseException {
        Map doctorChatM = parseToMap(info);

        DoctorChat doctorChat = new DoctorChat();

        if (flag){
            if (doctorChatM.get("sent") != null && doctorChatM.get("received") != null && doctorChatM.get("content") != null
                    && doctorChatM.get("datetime") != null){
                doctorChat.setSent((int) (double) doctorChatM.get("sent"));
                doctorChat.setReceived((int) (double) doctorChatM.get("received"));
                doctorChat.setContent((String) doctorChatM.get("content"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) doctorChatM.get("datetime"));
                doctorChat.setDatetime(date);
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (doctorChatM.get("sent") != null){
                doctorChat.setSent((int) (double) doctorChatM.get("sent"));
            }

            if (doctorChatM.get("received") != null) {
                doctorChat.setReceived((int) (double) doctorChatM.get("received"));
            }

            doctorChat.setContent((String) doctorChatM.get("content"));

            if (doctorChatM.get("datetime") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) doctorChatM.get("datetime"));
                doctorChat.setDatetime(date);
            }
        }

        return doctorChat;
    }

    public Doctor parseToDoctor(String info, boolean flag){
        Map doctorM = parseToMap(info);

        Doctor doctor = new Doctor();

        if (flag){
            if (doctorM.get("name") != null && doctorM.get("phone") != null){
                doctor.setName((String) doctorM.get("name"));
                doctor.setPhone((String) doctorM.get("phone"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            doctor.setName((String) doctorM.get("name"));
            doctor.setPhone((String) doctorM.get("phone"));
        }

        return doctor;
    }

    public DoctorUser parseToDoctorUser(String info, boolean flag){
        Map doctorUserM = parseToMap(info);

        DoctorUser doctorUser = new DoctorUser();

        if (flag){
            if (doctorUserM.get("doctorId") != null && doctorUserM.get("userId") != null && doctorUserM.get("doctorName") != null){
                doctorUser.setDoctorId((int) (double) doctorUserM.get("doctorId"));
                doctorUser.setUserId((int) (double) doctorUserM.get("userId"));
                doctorUser.setDoctorName((String) doctorUserM.get("doctorName"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (doctorUserM.get("doctorId") != null){
                doctorUser.setDoctorId((int) (double) doctorUserM.get("doctorId"));
            }

            if (doctorUserM.get("userId") != null){
                doctorUser.setUserId((int) (double) doctorUserM.get("userId"));
            }

            doctorUser.setDoctorName((String) doctorUserM.get("doctorName"));
        }

        return doctorUser;
    }

    public FoodAnalysis parseToFoodAnalysis(String info, boolean flag) throws ParseException {
        Map foodAnalysisM = parseToMap(info);

        FoodAnalysis foodAnalysis = new FoodAnalysis();

        if (flag){
            if (foodAnalysisM.get("userId") != null && foodAnalysisM.get("date") != null && foodAnalysisM.get("mealType") != null
                    && foodAnalysisM.get("energy") != null && foodAnalysisM.get("protein") != null && foodAnalysisM.get("fat") != null
                    && foodAnalysisM.get("cho") != null && foodAnalysisM.get("na") != null && foodAnalysisM.get("vegetableFruit") != null){
                foodAnalysis.setUserId((int) (double) foodAnalysisM.get("userId"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) foodAnalysisM.get("date"));
                foodAnalysis.setDate(date);
                foodAnalysis.setMealType((int) (double) foodAnalysisM.get("mealType"));
                foodAnalysis.setEnergy((float) (double) foodAnalysisM.get("energy"));
                foodAnalysis.setProtein((float) (double) foodAnalysisM.get("protein"));
                foodAnalysis.setFat((float) (double) foodAnalysisM.get("fat"));
                foodAnalysis.setCho((float) (double) foodAnalysisM.get("cho"));
                foodAnalysis.setNa((float) (double) foodAnalysisM.get("na"));
                foodAnalysis.setVegetableFruit((float) (double) foodAnalysisM.get("vegetableFruit"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (foodAnalysisM.get("userId") != null){
                foodAnalysis.setUserId((int) (double) foodAnalysisM.get("userId"));
            }

            if ( foodAnalysisM.get("date") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) foodAnalysisM.get("date"));
                foodAnalysis.setDate(date);
            }

            if (foodAnalysisM.get("mealType") != null){
                foodAnalysis.setMealType((int) (double) foodAnalysisM.get("mealType"));
            }

            if (foodAnalysisM.get("energy") != null){
                foodAnalysis.setEnergy((float) (double) foodAnalysisM.get("energy"));
            }

            if (foodAnalysisM.get("protein") != null){
                foodAnalysis.setProtein((float) (double) foodAnalysisM.get("protein"));
            }

            if (foodAnalysisM.get("fat") != null){
                foodAnalysis.setFat((float) (double) foodAnalysisM.get("fat"));
            }

            if (foodAnalysisM.get("cho") != null){
                foodAnalysis.setCho((float) (double) foodAnalysisM.get("cho"));
            }

            if (foodAnalysisM.get("na") != null){
                foodAnalysis.setNa((float) (double) foodAnalysisM.get("na"));
            }

            if (foodAnalysisM.get("vegetableFruit") != null){
                foodAnalysis.setVegetableFruit((float) (double) foodAnalysisM.get("vegetableFruit"));
            }
        }

        return foodAnalysis;
    }

    public FoodDetail parseToFoodDetail(String info, boolean flag){
        Map foodDetailM = parseToMap(info);

        FoodDetail foodDetail = new FoodDetail();

        if (flag){
            if (foodDetailM.get("recordId") != null && foodDetailM.get("foodId") != null && foodDetailM.get("weight") != null
                    && foodDetailM.get("foodName") != null && foodDetailM.get("foodTypeId") != null && foodDetailM.get("userId") != null){
                foodDetail.setRecordId((int) (double) foodDetailM.get("recordId"));
                foodDetail.setFoodId((int) (double) foodDetailM.get("foodId"));
                foodDetail.setWeight((float) (double) foodDetailM.get("weight"));
                foodDetail.setFoodName((String) foodDetailM.get("foodName"));
                foodDetail.setFoodTypeId((int) (double) foodDetailM.get("foodTypeId"));
                foodDetail.setUserId((int) (double) foodDetailM.get("userId"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (foodDetailM.get("recordId") != null){
                foodDetail.setRecordId((int) (double) foodDetailM.get("recordId"));
            }

            if (foodDetailM.get("foodId") != null){
                foodDetail.setFoodId((int) (double) foodDetailM.get("foodId"));
            }

            if (foodDetailM.get("weight") != null){
                foodDetail.setWeight((float) (double) foodDetailM.get("weight"));
            }

            if (foodDetailM.get("foodName") != null){
                foodDetail.setFoodName((String) foodDetailM.get("foodName"));
            }

            if (foodDetailM.get("foodTypeId") != null){
                foodDetail.setFoodTypeId((int) (double) foodDetailM.get("foodTypeId"));
            }

            if (foodDetailM.get("userId") != null){
                foodDetail.setUserId((int) (double) foodDetailM.get("userId"));
            }
        }



        return foodDetail;
    }

    public FoodRecommend parseToFoodRecommend(String info, boolean flag){
        Map foodRecommendM = parseToMap(info);

        FoodRecommend foodRecommend = new FoodRecommend();

        if (flag){
            if (foodRecommendM.get("foodId") != null && foodRecommendM.get("name") != null && foodRecommendM.get("weight") != null &&
                    foodRecommendM.get("mealType") != null && foodRecommendM.get("suit") != null && foodRecommendM.get("package") != null &&
                    foodRecommendM.get("comment") != null){
                foodRecommend.setFoodId((int) (double) foodRecommendM.get("foodId"));
                foodRecommend.setName((String) foodRecommendM.get("name"));
                foodRecommend.setWeight((String) foodRecommendM.get("weight"));
                foodRecommend.setMealType((int) (double) foodRecommendM.get("mealType"));
                foodRecommend.setSuit((int) (double) foodRecommendM.get("suit"));
                foodRecommend.setPackages((int) (double) foodRecommendM.get("package"));
                foodRecommend.setComment((String) foodRecommendM.get("comment"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (foodRecommendM.get("foodId") != null){
                foodRecommend.setFoodId((int) (double) foodRecommendM.get("foodId"));
            }

            foodRecommend.setName((String) foodRecommendM.get("name"));

            foodRecommend.setWeight((String) foodRecommendM.get("weight"));

            if (foodRecommendM.get("mealType") != null){
                foodRecommend.setMealType((int) (double) foodRecommendM.get("mealType"));
            }

            if (foodRecommendM.get("suit") != null){
                foodRecommend.setSuit((int) (double) foodRecommendM.get("suit"));
            }

            if (foodRecommendM.get("package") != null){
                foodRecommend.setPackages((int) (double) foodRecommendM.get("package"));
            }

            foodRecommend.setComment((String) foodRecommendM.get("comment"));
        }



        return foodRecommend;
    }

    public FoodRecord parseToFoodRecord(String info, boolean flag) throws ParseException {
        Map foodRecordM = parseToMap(info);

        FoodRecord foodRecord = new FoodRecord();

        if (flag){
            if (foodRecordM.get("userId") != null && foodRecordM.get("memo") != null && foodRecordM.get("datetime") != null &&
                    foodRecordM.get("mealType") != null){
                foodRecord.setUserId((int) (double) foodRecordM.get("userId"));
                foodRecord.setMemo((String) foodRecordM.get("memo"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) foodRecordM.get("datetime"));
                foodRecord.setDatetime(date);
                foodRecord.setMealType((int) (double) foodRecordM.get("mealType"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (foodRecordM.get("userId") != null){
                foodRecord.setUserId((int) (double) foodRecordM.get("userId"));
            }

            foodRecord.setMemo((String) foodRecordM.get("memo"));

            if (foodRecordM.get("datetime") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) foodRecordM.get("datetime"));
                foodRecord.setDatetime(date);
            }

            if (foodRecordM.get("mealType") != null){
                foodRecord.setMealType((int) (double) foodRecordM.get("mealType"));
            }
        }


        return foodRecord;
    }

    public Food parseToFood(String info, boolean flag){
        Map foodM = parseToMap(info);

        Food food = new Food();

        if (flag){
            if (foodM.get("name") != null && foodM.get("type") != null && foodM.get("energy") != null && foodM.get("protein") != null && foodM.get("fat") != null && foodM.get("cho") != null && foodM.get("na") != null){
                food.setName((String) foodM.get("name"));
                food.setType((int) (double) foodM.get("type"));
                food.setEnergy((float) (double) foodM.get("energy"));
                food.setProtein((float) (double) foodM.get("protein"));
                food.setFat((float) (double) foodM.get("fat"));
                food.setCho((float) (double) foodM.get("cho"));
                food.setNa((float) (double) foodM.get("na"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            food.setName((String) foodM.get("name"));

            if (foodM.get("type") != null){
                food.setType((int) (double) foodM.get("type"));
            }

            if (foodM.get("energy") != null){
                food.setEnergy((float) (double) foodM.get("energy"));
            }

            if (foodM.get("protein") != null){
                food.setProtein((float) (double) foodM.get("protein"));
            }

            if (foodM.get("fat") != null){
                food.setFat((float) (double) foodM.get("fat"));
            }

            if (foodM.get("cho") != null){
                food.setCho((float) (double) foodM.get("cho"));
            }

            if (foodM.get("na") != null){
                food.setNa((float) (double) foodM.get("na"));
            }
        }

        return food;
    }

    public GluPlan parseToGluPlan(String info, boolean flag){
        Map gluPlanM = parseToMap(info);

        GluPlan gluPlan = new GluPlan();

        if (flag){
            if (gluPlanM.get("userId") != null && gluPlanM.get("target") != null && gluPlanM.get("time") != null && gluPlanM.get("weekFre") != null &&
                    gluPlanM.get("dayFre") != null){
                gluPlan.setUserId((int) (double) gluPlanM.get("userId"));
                gluPlan.setTarget((float) (double) gluPlanM.get("target"));
                gluPlan.setTime((int) (double) gluPlanM.get("time"));
                gluPlan.setWeekFre((int) (double) gluPlanM.get("weekFre"));
                gluPlan.setDayFre((int) (double) gluPlanM.get("dayFre"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (gluPlanM.get("userId") != null){
                gluPlan.setUserId((int) (double) gluPlanM.get("userId"));
            }

            if (gluPlanM.get("target") != null){
                gluPlan.setTarget((float) (double) gluPlanM.get("target"));
            }

            if (gluPlanM.get("time") != null){
                gluPlan.setTime((int) (double) gluPlanM.get("time"));
            }

            if (gluPlanM.get("weekFre") != null){
                gluPlan.setWeekFre((int) (double) gluPlanM.get("weekFre"));
            }

            if (gluPlanM.get("dayFre") != null){
                gluPlan.setDayFre((int) (double) gluPlanM.get("dayFre"));
            }
        }


        return gluPlan;
    }

    public GluRecord parseToGluRecord(String info, boolean flag) throws ParseException {
        Map gluRecordM = parseToMap(info);

        GluRecord gluRecord = new GluRecord();

        if (flag){
            if (gluRecordM.get("userId") != null && gluRecordM.get("planId") != null && gluRecordM.get("date") != null && gluRecordM.get("value") != null){
                gluRecord.setUserId((int) (double) gluRecordM.get("userId"));
                gluRecord.setPlanId((int) (double) gluRecordM.get("planId"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) gluRecordM.get("date"));
                gluRecord.setDate(date);
                gluRecord.setValue((float) (double) gluRecordM.get("value"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (gluRecordM.get("userId") != null){
                gluRecord.setUserId((int) (double) gluRecordM.get("userId"));
            }

            if (gluRecordM.get("planId") != null){
                gluRecord.setPlanId((int) (double) gluRecordM.get("planId"));
            }

            if (gluRecordM.get("date") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) gluRecordM.get("date"));
                gluRecord.setDate(date);
            }

            if (gluRecordM.get("value") != null){
                gluRecord.setValue((float) (double) gluRecordM.get("value"));
            }
        }


        return gluRecord;
    }

    public MedicinePlan parseToMedicinePlan(String info, boolean flag){
        Map medicinePlanM = parseToMap(info);

        MedicinePlan medicinePlan = new MedicinePlan();

        if (flag){
            if (medicinePlanM.get("userId") != null && medicinePlanM.get("name") != null && medicinePlanM.get("dasage") != null && medicinePlanM.get("time") != null &&
                    medicinePlanM.get("weekFre") != null && medicinePlanM.get("dayFre") != null){
                medicinePlan.setUserId((int) (double) medicinePlanM.get("userId"));
                medicinePlan.setName((String) medicinePlanM.get("name"));
                medicinePlan.setDasage((String) medicinePlanM.get("dasage"));
                medicinePlan.setTime((int) (double) medicinePlanM.get("time"));
                medicinePlan.setWeekFre((int) (double) medicinePlanM.get("weekFre"));
                medicinePlan.setDayFre((int) (double) medicinePlanM.get("dayFre"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (medicinePlanM.get("userId") != null){
                medicinePlan.setUserId((int) (double) medicinePlanM.get("userId"));
            }

            medicinePlan.setName((String) medicinePlanM.get("name"));
            medicinePlan.setDasage((String) medicinePlanM.get("dasage"));

            if (medicinePlanM.get("time") != null){
                medicinePlan.setTime((int) (double) medicinePlanM.get("time"));
            }

            if (medicinePlanM.get("weekFre") != null){
                medicinePlan.setWeekFre((int) (double) medicinePlanM.get("weekFre"));
            }

            if (medicinePlanM.get("dayFre") != null){
                medicinePlan.setDayFre((int) (double) medicinePlanM.get("dayFre"));
            }
        }

        return medicinePlan;
    }

    public MedicineRecord parseToMedicineRecord(String info, boolean flag) throws ParseException {
        Map medicineRecordM = parseToMap(info);

        MedicineRecord medicineRecord = new MedicineRecord();

        if (flag){
            if (medicineRecordM.get("userId") != null && medicineRecordM.get("planId") != null && medicineRecordM.get("date") != null && medicineRecordM.get("did") != null){
                medicineRecord.setUserId((int) (double) medicineRecordM.get("userId"));
                medicineRecord.setPlanId((int) (double) medicineRecordM.get("planId"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) medicineRecordM.get("date"));
                medicineRecord.setDate(date);
                medicineRecord.setDid((int) (double) medicineRecordM.get("did"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (medicineRecordM.get("userId") != null){
                medicineRecord.setUserId((int) (double) medicineRecordM.get("userId"));
            }

            if (medicineRecordM.get("planId") != null){
                medicineRecord.setPlanId((int) (double) medicineRecordM.get("planId"));
            }

            if (medicineRecordM.get("date") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) medicineRecordM.get("date"));
                medicineRecord.setDate(date);
            }

            if (medicineRecordM.get("did") != null){
                medicineRecord.setDid((int) (double) medicineRecordM.get("did"));
            }
        }


        return medicineRecord;
    }

    public SportDefault parseToSportDefault(String info, boolean flag){
        Map sportDefaultM = parseToMap(info);

        SportDefault sportDefault = new SportDefault();

        if (flag){
            if (sportDefaultM.get("suit") != null && sportDefaultM.get("sportId") != null && sportDefaultM.get("weekday") != null && sportDefaultM.get("comment") != null){
                sportDefault.setSuit((int) (double) sportDefaultM.get("suit"));
                sportDefault.setSportId((int) (double) sportDefaultM.get("sportId"));
                sportDefault.setWeekday((int) (double) sportDefaultM.get("weekday"));
                sportDefault.setComment((String) sportDefaultM.get("comment"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (sportDefaultM.get("suit") != null){
                sportDefault.setSuit((int) (double) sportDefaultM.get("suit"));
            }

            if (sportDefaultM.get("sportId") != null){
                sportDefault.setSportId((int) (double) sportDefaultM.get("sportId"));
            }

            if (sportDefaultM.get("weekday") != null){
                sportDefault.setWeekday((int) (double) sportDefaultM.get("weekday"));
            }

            sportDefault.setComment((String) sportDefaultM.get("comment"));
        }


        return sportDefault;
    }

    public SportItem parseToSportItem(String info, boolean flag){
        Map sportItemM = parseToMap(info);

        SportItem sportItem = new SportItem();

        if (flag){
            if (sportItemM.get("name") != null && sportItemM.get("timeType") != null && sportItemM.get("type") != null){
                sportItem.setName((String) sportItemM.get("name"));
                sportItem.setTimeType((int) (double) sportItemM.get("timeType"));
                sportItem.setType((int) (double) sportItemM.get("type"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            sportItem.setName((String) sportItemM.get("name"));

            if (sportItemM.get("timeType") != null){
                sportItem.setTimeType((int) (double) sportItemM.get("timeType"));
            }

            if (sportItemM.get("type") != null){
                sportItem.setType((int) (double) sportItemM.get("type"));
            }
        }

        return sportItem;
    }

    public SportUser parseToSportUser(String info, boolean flag){
        Map sportUserM = parseToMap(info);

        SportUser sportUser = new SportUser();

        if (flag){
            if (sportUserM.get("userId") != null && sportUserM.get("sportId") != null && sportUserM.get("weekday") != null && sportUserM.get("comment") != null){
                sportUser.setUserId((int) (double) sportUserM.get("userId"));
                sportUser.setSportId((int) (double) sportUserM.get("sportId"));
                sportUser.setWeekday((int) (double) sportUserM.get("weekday"));
                sportUser.setComment((String) sportUserM.get("comment"));
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (sportUserM.get("userId") != null){
                sportUser.setUserId((int) (double) sportUserM.get("userId"));
            }

            if (sportUserM.get("sportId") != null){
                sportUser.setSportId((int) (double) sportUserM.get("sportId"));
            }

            if (sportUserM.get("weekday") != null){
                sportUser.setWeekday((int) (double) sportUserM.get("weekday"));
            }

            sportUser.setComment((String) sportUserM.get("comment"));
        }


        return sportUser;
    }

    public UserAuth parseToUserAuth(String info, boolean flag) throws ParseException {
        Map userAuthM = parseToMap(info);

        UserAuth userAuth = new UserAuth();

        if (flag){
            if (userAuthM.get("phone") != null && userAuthM.get("password") != null && userAuthM.get("registerTime") != null && userAuthM.get("lastLoginTime") != null){
                userAuth.setPhone((String) userAuthM.get("phone"));
                userAuth.setPassword((String) userAuthM.get("password"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) userAuthM.get("registerTime"));
                userAuth.setRegisterTime(date);
                date = fmt.parse((String) userAuthM.get("lastLoginTime"));
                userAuth.setLastLoginTime(date);
            }else {
                System.out.println("缺少参数");
            }
        }else {
            userAuth.setPhone((String) userAuthM.get("phone"));
            userAuth.setPassword((String) userAuthM.get("password"));

            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            if (userAuthM.get("registerTime") != null){
                Date date = fmt.parse((String) userAuthM.get("registerTime"));
                userAuth.setRegisterTime(date);
            }

            if (userAuthM.get("lastLoginTime") != null){
                Date date = fmt.parse((String) userAuthM.get("lastLoginTime"));
                userAuth.setLastLoginTime(date);
            }
        }


        return userAuth;
    }

    public UserInfo parseToUserInfo(String info, boolean flag) throws ParseException {
        Map userInfoM = parseToMap(info);

        UserInfo userInfo = new UserInfo();

        if (flag){
            if (userInfoM.get("userId") != null && userInfoM.get("birth") != null && userInfoM.get("sex") != null && userInfoM.get("height") != null &&
                    userInfoM.get("weight") != null && userInfoM.get("bmi") != null && userInfoM.get("intensity") != null){
                userInfo.setUserId((int) (double) userInfoM.get("userId"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) userInfoM.get("birth"));
                userInfo.setBirth(date);
                userInfo.setSex((int) (double) userInfoM.get("sex"));
                userInfo.setHeight((double) userInfoM.get("height"));
                userInfo.setWeight((double) userInfoM.get("weight"));
                userInfo.setBmi((double) userInfoM.get("bmi"));
                userInfo.setIntensity((int) (double) userInfoM.get("intensity"));
                userInfo.setLevel((int) (double) userInfoM.get("level"));
                userInfo.setIsCondition1((int) (double) userInfoM.get("isCondition1"));
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition2"));
                userInfo.setIsCondition3((int) (double) userInfoM.get("isCondition3"));
                userInfo.setIsCondition4((int) (double) userInfoM.get("isCondition4"));
                userInfo.setIsCondition5((int) (double) userInfoM.get("isCondition5"));
                userInfo.setIsCondition6((int) (double) userInfoM.get("isCondition6"));
                userInfo.setIsCondition7((int) (double) userInfoM.get("isCondition7"));
                userInfo.setIsCondition8((int) (double) userInfoM.get("isCondition8"));
                userInfo.setIsCondition9((int) (double) userInfoM.get("isCondition9"));
                userInfo.setIsCondition10((int) (double) userInfoM.get("isCondition10"));
                userInfo.setIsCondition11((int) (double) userInfoM.get("isCondition11"));
                userInfo.setIsCondition12((int) (double) userInfoM.get("isCondition12"));
                userInfo.setIsCondition13((int) (double) userInfoM.get("isCondition13"));
//             && userInfoM.get("level") != null &&
//                    userInfoM.get("isCondition1") != null && userInfoM.get("isCondition2") != null && userInfoM.get("isCondition3") != null && userInfoM.get("isCondition4") != null &&
//                    userInfoM.get("isCondition5") != null && userInfoM.get("isCondition6") != null && userInfoM.get("isCondition7") != null && userInfoM.get("isCondition8") != null &&
//                    userInfoM.get("isCondition9") != null && userInfoM.get("isCondition10") != null && userInfoM.get("isCondition11") != null && userInfoM.get("isCondition12") != null &&
//                    userInfoM.get("isCondition13") != null
            }else {
                System.out.println("缺少参数");
            }
        }else {
            if (userInfoM.get("userId") != null){
                userInfo.setUserId((int) (double) userInfoM.get("userId"));
            }

            if (userInfoM.get("birth") != null){
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Date date = fmt.parse((String) userInfoM.get("birth"));
                userInfo.setBirth(date);
            }

            if (userInfoM.get("sex") != null){
                userInfo.setSex((int) (double) userInfoM.get("sex"));
            }

            if (userInfoM.get("height") != null){
                userInfo.setHeight((double) userInfoM.get("height"));
            }

            if (userInfoM.get("weight") != null){
                userInfo.setWeight((double) userInfoM.get("weight"));
            }

            if (userInfoM.get("bmi") != null){
                userInfo.setBmi((double) userInfoM.get("bmi"));
            }

            if (userInfoM.get("intensity") != null){
                userInfo.setIntensity((int) (double) userInfoM.get("intensity"));
            }

            if (userInfoM.get("level") != null){
                userInfo.setLevel((int) (double) userInfoM.get("level"));
            }

            if (userInfoM.get("isCondition1") != null){
                userInfo.setIsCondition1((int) (double) userInfoM.get("isCondition1"));
            }

            if (userInfoM.get("isCondition2") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition2"));
            }

            if (userInfoM.get("isCondition3") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition3"));
            }

            if (userInfoM.get("isCondition4") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition4"));
            }

            if (userInfoM.get("isCondition5") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition5"));
            }

            if (userInfoM.get("isCondition6") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition6"));
            }

            if (userInfoM.get("isCondition7") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition7"));
            }

            if (userInfoM.get("isCondition8") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition8"));
            }

            if (userInfoM.get("isCondition9") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition9"));
            }

            if (userInfoM.get("isCondition10") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition10"));
            }

            if (userInfoM.get("isCondition11") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition11"));
            }

            if (userInfoM.get("isCondition12") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition12"));
            }

            if (userInfoM.get("isCondition13") != null){
                userInfo.setIsCondition2((int) (double) userInfoM.get("isCondition13"));
            }
        }


        return userInfo;
    }
}
