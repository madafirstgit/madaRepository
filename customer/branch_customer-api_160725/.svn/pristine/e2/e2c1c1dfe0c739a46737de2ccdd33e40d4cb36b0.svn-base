//package com.pzj.util;
//
//import com.pzj.base.service.product.IProductReleaseService;
//import com.pzj.base.service.sys.*;
//import com.pzj.base.service.sys.cache.SysRedisService;
//import com.pzj.base.service.sys.cache.UserRedisService;
//
//public class RemoteServiceFactory {
//    private RemoteServiceFactory() {
//    }
//
//    private static final String IUserService = "iuserService";
//    private static final String IMenuService = "imenuService";
//    private static final String IUserAuthMenuService = "iuserAuthMenuService";
//    private static final String IUserAuthRoleService = "iuserAuthRoleService";
//    private static final String IRoleService = "iroleService";
//    private static final String IUserAuthOfficeService = "iuserAuthOfficeService";
//    private static final String IOfficeService = "iofficeService";
//    private static final String IRoleAuthOfficeService = "iroleAuthOfficeService";
//    private static final String IRoleAuthMenuService = "iroleAuthMenuService";
//    private static final String IDictService = "idictService";
//    private static final String ILabelService = "ilabelService";
//    private static final String ILogService = "ilogService";
//    private static final String IChannelService = "ichannelService";
//    private static final String IChannelStrategyService = "ichannelStrategyService";
//    private static final String ILabelRelationService = "ilabelRelationService";
//    private static final String IRebateStrategyService = "irebateStrategyService";
//    private static final String ISpcreRelationService = "ispcreRelationService";
//    private static final String IExtraRebateStrategyService = "iextraRebateStrategyService";
//    private static final String IUserRedisCacheService = "userCacheService";// 用户缓存接口服务
//    private static final String ISysRedisCacheService = "sysCacheService";// 系统缓存
//    private static final String ISysUserRelationService = "sysUserRelationService";
//    private static final String IProductReleaseService = "iproductReleaseService";// 产品接口服务
//    private static final String ISysSettlementRuleService = "isysSettlementRuleService"; // 政策减免结算服务
//    private static final String ISysUserAgentService = "isysUserAgentService"; // 用户与代理服务
//
//    private static class ISysSettlementRuleServiceHelp {
//        private final static ISysSettlementRuleService uniqueInstance;
//        static {
//            uniqueInstance = (ISysSettlementRuleService) SpringBeanLoader
//                    .getSpringBean(ISysSettlementRuleService);
//        }
//    }
//
//    public static ISysSettlementRuleService getISysSettlementRuleServiceInstance() {
//        return ISysSettlementRuleServiceHelp.uniqueInstance;
//    }
//
//    private static class IProductReleaseServiceHelp {
//        private final static IProductReleaseService uniqueInstance;
//        static {
//            uniqueInstance = (IProductReleaseService) SpringBeanLoader
//                    .getSpringBean(IProductReleaseService);
//        }
//    }
//
//    public static IProductReleaseService getIProductReleaseServiceInstance() {
//        return IProductReleaseServiceHelp.uniqueInstance;
//    }
//
//    private static class ISpcreRelationServiceHelp {
//        private final static ISpcreRelationService uniqueInstance;
//        static {
//            uniqueInstance = (ISpcreRelationService) SpringBeanLoader
//                    .getSpringBean(ISpcreRelationService);
//        }
//    }
//
//    public static ISpcreRelationService getISpcreRelationServiceInstance() {
//        return ISpcreRelationServiceHelp.uniqueInstance;
//    }
//
//    private static class IChannelServiceHelp {
//        private final static IChannelService uniqueInstance;
//        static {
//            uniqueInstance = (IChannelService) SpringBeanLoader
//                    .getSpringBean(IChannelService);
//        }
//    }
//
//    public static IChannelService getIChannelServiceInstance() {
//        return IChannelServiceHelp.uniqueInstance;
//    }
//
//    private static class IChannelStrategyServiceHelp {
//        private final static IChannelStrategyService uniqueInstance;
//        static {
//            uniqueInstance = (IChannelStrategyService) SpringBeanLoader
//                    .getSpringBean(IChannelStrategyService);
//        }
//    }
//
//    public static IChannelStrategyService getIChannelStrategyServiceInstance() {
//        return IChannelStrategyServiceHelp.uniqueInstance;
//    }
//
//    private static class ILabelRelationServiceHelp {
//        private final static ILabelRelationService uniqueInstance;
//        static {
//            uniqueInstance = (ILabelRelationService) SpringBeanLoader
//                    .getSpringBean(ILabelRelationService);
//        }
//    }
//
//    public static ILabelRelationService getILabelRelationServiceInstance() {
//        return ILabelRelationServiceHelp.uniqueInstance;
//    }
//
//    private static class IRebateStrategyServiceHelp {
//        private final static IRebateStrategyService uniqueInstance;
//        static {
//            uniqueInstance = (IRebateStrategyService) SpringBeanLoader
//                    .getSpringBean(IRebateStrategyService);
//        }
//    }
//
//    public static IRebateStrategyService getIRebateStrategyServiceInstance() {
//        return IRebateStrategyServiceHelp.uniqueInstance;
//    }
//
//    private static class IUserServiceHelp {
//        private final static IUserService uniqueInstance;
//        static {
//            uniqueInstance = (IUserService) SpringBeanLoader
//                    .getSpringBean(IUserService);
//        }
//    }
//
//    public static IUserService getIUserServiceInstance() {
//        return IUserServiceHelp.uniqueInstance;
//    }
//
//    private static class IMenuServiceHelp {
//        private final static IMenuService uniqueInstance;
//        static {
//            uniqueInstance = (IMenuService) SpringBeanLoader
//                    .getSpringBean(IMenuService);
//        }
//    }
//
//    public static IMenuService getIMenuServiceInstance() {
//        return IMenuServiceHelp.uniqueInstance;
//    }
//
//    private static class IUserAuthMenuServiceHelp {
//        private final static IUserAuthMenuService uniqueInstance;
//        static {
//            uniqueInstance = (IUserAuthMenuService) SpringBeanLoader
//                    .getSpringBean(IUserAuthMenuService);
//        }
//    }
//
//    public static IUserAuthMenuService getIUserAuthMenuServiceInstance() {
//        return IUserAuthMenuServiceHelp.uniqueInstance;
//    }
//
//    private static class IUserAuthRoleServiceHelp {
//        private final static IUserAuthRoleService uniqueInstance;
//        static {
//            uniqueInstance = (IUserAuthRoleService) SpringBeanLoader
//                    .getSpringBean(IUserAuthRoleService);
//        }
//    }
//
//    public static IUserAuthRoleService getIUserAuthRoleServiceInstance() {
//        return IUserAuthRoleServiceHelp.uniqueInstance;
//    }
//
//    private static class IRoleServiceHelp {
//        private final static IRoleService uniqueInstance;
//        static {
//            uniqueInstance = (IRoleService) SpringBeanLoader
//                    .getSpringBean(IRoleService);
//        }
//    }
//
//    public static IRoleService getIRoleServiceInstance() {
//        return IRoleServiceHelp.uniqueInstance;
//    }
//
//    private static class IUserAuthOfficeServiceHelp {
//        private final static IUserAuthOfficeService uniqueInstance;
//        static {
//            uniqueInstance = (IUserAuthOfficeService) SpringBeanLoader
//                    .getSpringBean(IUserAuthOfficeService);
//        }
//    }
//
//    public static IUserAuthOfficeService getIUserAuthOfficeServiceInstance() {
//        return IUserAuthOfficeServiceHelp.uniqueInstance;
//    }
//
//    private static class IOfficeServiceHelp {
//        private final static IOfficeService uniqueInstance;
//        static {
//            uniqueInstance = (IOfficeService) SpringBeanLoader
//                    .getSpringBean(IOfficeService);
//        }
//    }
//
//    public static IOfficeService getIOfficeServiceInstance() {
//        return IOfficeServiceHelp.uniqueInstance;
//    }
//
//    private static class IRoleAuthOfficeServiceHelp {
//        private final static IRoleAuthOfficeService uniqueInstance;
//        static {
//            uniqueInstance = (IRoleAuthOfficeService) SpringBeanLoader
//                    .getSpringBean(IRoleAuthOfficeService);
//        }
//    }
//
//    public static IRoleAuthOfficeService getIRoleAuthOfficeServiceInstance() {
//        return IRoleAuthOfficeServiceHelp.uniqueInstance;
//    }
//
//    private static class IRoleAuthMenuServiceHelp {
//        private final static IRoleAuthMenuService uniqueInstance;
//        static {
//            uniqueInstance = (IRoleAuthMenuService) SpringBeanLoader
//                    .getSpringBean(IRoleAuthMenuService);
//        }
//    }
//
//    public static IRoleAuthMenuService getIRoleAuthMenuServiceInstance() {
//        return IRoleAuthMenuServiceHelp.uniqueInstance;
//    }
//
//    private static class IDictServiceHelp {
//        private final static IDictService uniqueInstance;
//        static {
//            uniqueInstance = (IDictService) SpringBeanLoader
//                    .getSpringBean(IDictService);
//        }
//    }
//
//    public static IDictService getIDictServiceInstance() {
//        return IDictServiceHelp.uniqueInstance;
//    }
//
//    private static class ILabelServiceHelp {
//        private final static ILabelService uniqueInstance;
//        static {
//            uniqueInstance = (ILabelService) SpringBeanLoader
//                    .getSpringBean(ILabelService);
//        }
//    }
//
//    public static ILabelService getILabelServiceInstance() {
//        return ILabelServiceHelp.uniqueInstance;
//    }
//
//    private static class ILogServiceHelp {
//        private final static ILogService uniqueInstance;
//        static {
//            uniqueInstance = (ILogService) SpringBeanLoader
//                    .getSpringBean(ILogService);
//        }
//    }
//
//    public static ILogService getILogServiceInstance() {
//        return ILogServiceHelp.uniqueInstance;
//    }
//
//    private static class IExtraRebateStrategyServiceHelp {
//        private final static IExtraRebateStrategyService uniqueInstance;
//        static {
//            uniqueInstance = (IExtraRebateStrategyService) SpringBeanLoader
//                    .getSpringBean(IExtraRebateStrategyService);
//        }
//    }
//
//    public static IExtraRebateStrategyService getIExtraRebateStrategyServiceInstance() {
//        return IExtraRebateStrategyServiceHelp.uniqueInstance;
//    }
//
//    /**
//     * 用户缓存
//     *
//     * @author apple
//     *
//     */
//    private static class IUserRedisCacheServiceHelp {
//        private final static UserRedisService uniqueInstance;
//        static {
//            uniqueInstance = (UserRedisService) SpringBeanLoader
//                    .getSpringBean(IUserRedisCacheService);
//        }
//    }
//
//    public static UserRedisService getUserRedisCacheServiceInstance() {
//        return IUserRedisCacheServiceHelp.uniqueInstance;
//    }
//
//    /**
//     * 系统缓存
//     *
//     * @author apple
//     *
//     */
//    private static class ISysRedisCacheServiceHelp {
//        private final static SysRedisService uniqueInstance;
//        static {
//            uniqueInstance = (SysRedisService) SpringBeanLoader
//                    .getSpringBean(ISysRedisCacheService);
//        }
//    }
//
//    public static SysRedisService getSysRedisCacheServiceInstance() {
//        return ISysRedisCacheServiceHelp.uniqueInstance;
//    }
//
//    private static class ISysUserRelationServiceHelp {
//        private final static ISysUserRelationService uniqueInstance;
//        static {
//            uniqueInstance = (ISysUserRelationService) SpringBeanLoader
//                    .getSpringBean(ISysUserRelationService);
//        }
//    }
//
//    public static ISysUserRelationService getISysUserRelationServiceInstance() {
//        return ISysUserRelationServiceHelp.uniqueInstance;
//    }
//
//
//    private static class ISysUserAgentServiceHelp {
//        private final static ISysUserAgentService uniqueInstance;
//        static {
//            uniqueInstance = (ISysUserAgentService) SpringBeanLoader
//                    .getSpringBean(ISysUserAgentService);
//        }
//    }
//
//    public static ISysUserAgentService getISysUserAgentServiceInstance() {
//        return ISysUserAgentServiceHelp.uniqueInstance;
//    }
//}
