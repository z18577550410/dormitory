import Vue from 'vue'
import VueRouter from 'vue-router'
//引入的页面
import Login from "@/views/Login";
import SystemAdmin from "@/views/SystemAdmin";
import DormitoryAdminAdd from "@/views/DormitoryAdminAdd";
import DormitoryAdminManager from "@/views/DormitoryAdminManager";
import DormitoryAdminUpdate from "@/views/DormitoryAdminUpdate";
import StudentAdd from "@/views/StudentAdd";
import StudentManager from "@/views/StudentManager";
import StudentUpdate from "@/views/StudentUpdate";
import BuildingAdd from "@/views/BuildingAdd";
import BuildingManager from "@/views/BuildingManager";
import BuildingUpdate from "@/views/BuildingUpdate";
import DormitoryAdd from "@/views/DormitoryAdd";
import DormitoryManager from "@/views/DormitoryManager";
import DormitoryUpdate from "@/views/DormitoryUpdate";
import MoveoutRegister from "@/views/MoveoutRegister";
import MoveRecord from "@/views/MoveRecord";
import AbsentRecord from "@/views/AbsentRecord";
import DormitoryAdmin from "@/views/DormitoryAdmin";
import AbsentRegister from "@/views/AbsentRegister";
//
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '登录',
        component: Login
    }
    , {
        path: '/login',
        name: '登录',
        component: Login
    }
    , {
        path: '/systemAdmin',
        name: '系统管理员',
        component: SystemAdmin,
        //默认页面
        redirect: '/studentManager',
        children: [
            {
                path: '/dormitoryAdminAdd',
                name: '添加宿舍管理员',
                component: DormitoryAdminAdd
            }
            , {
                path: '/dormitoryAdminManager',
                name: '宿舍管理员管理页面',
                component: DormitoryAdminManager
            }
            , {
                path: '/dormitoryAdminUpdate',
                name: '修改宿舍管理员信息',
                component: DormitoryAdminUpdate
            }
            , {
                path: '/studentAdd',
                name: '添加学生',
                component: StudentAdd
            }
            , {
                path: '/studentManager',
                name: '学生模块>学生管理',
                component: StudentManager
            }
            , {
                path: '/studentUpdate',
                name: '修改学生',
                component: StudentUpdate
            }
            , {
                path: '/buildingAdd',
                name: '添加楼宇',
                component: BuildingAdd
            }
            , {
                path: '/buildingManager',
                name: '添加楼宇',
                component: BuildingManager
            }
            , {
                path: '/buildingUpdate',
                name: '修改楼宇',
                component: BuildingUpdate
            }
            , {
                path: '/dormitoryAdd',
                name: '添加宿舍',
                component: DormitoryAdd
            }
            , {
                path: '/dormitoryManager',
                name: '宿舍管理',
                component: DormitoryManager
            }
            , {
                path: '/dormitoryUpdate',
                name: '修改宿舍',
                component: DormitoryUpdate
            }
            , {
                path: '/moveoutRegister',
                name: '迁出登记',
                component: MoveoutRegister
            }
            , {
                path: '/moveoutRecord',
                name: '迁出记录',
                component: MoveRecord
            }
            , {
                path: '/absentRecord',
                name: '学生缺寝记录',
                component: AbsentRecord
            }
        ]
    }
    , {
        path: '/dormitoryAdmin',
        name: '宿舍管理员',
        component: DormitoryAdmin,
        redirect: '/absentRecord2',
        children: [
            {
                path: '/absentRecord2',
                name: '学生缺寝记录',
                component: AbsentRecord
            }
            ,{
                path: '/absentRegister',
                name: '学生缺寝登记',
                component: AbsentRegister
            }

        ]
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
