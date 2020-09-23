package so.wwb.lotterybox.common.dubbo;

import org.soul.commons.dubbo.DubboTool;
import org.soul.iservice.test.IDbValidService;

public class ServiceTool {
    private static String dubboApplicationName;
    protected static <T> T getService(Class<T> interfaceClazz) {
        return DubboTool.getServiceByAppName(interfaceClazz, dubboApplicationName);
    }
    public  void setDubboApplicationName(String appName){
        dubboApplicationName=appName;
    }
        public static String getDubboApplicationName(){
        return dubboApplicationName;
    }
    public static IDbValidService dbValidService() {
        return getService(IDbValidService.class);
    }

//    public static ILotteryResultService lotterResultService() {
//        return getService(ILotteryResultService.class);
//    }
//
//    public static ILotteryResultService lotteryResultService() {
//        return getService(ILotteryResultService.class);
//    }
//
//    public static IUserBankcardService userBankcardService() {
//        return getService(IUserBankcardService.class);
//    }
//
//    public static IUserParamService userParamService() {
//        return getService(IUserParamService.class);
//    }
//
//    public static IUserAssetsService userAssetsService() {
//        return getService(IUserAssetsService.class);
//    }
//
//    public static IContentBulletinService contentBulletinService() {
//        return getService(IContentBulletinService.class);
//    }
//
//    public static IVUserPlayerService vUserPlayerService() {
//        return getService(IVUserPlayerService.class);
//    }
//    public static IVPlayerOnlineService vPlayerOnlineService() {
//        return getService(IVPlayerOnlineService.class);
//    }
//
//    public static ISysResourceService sysResourceService(){return getService(ISysResourceService.class);}
//
//    public static IVSysSiteManageService vSysSiteManageService(){return getService(IVSysSiteManageService.class);}
//
//    public static IDefenseRecordService defenseRecordService(){return getService(IDefenseRecordService.class);}
//
//    public static IIpDbService ipDbService(){return getService(IIpDbService.class);}
//
//    public static IVSysSiteDomainService vSysSiteDomainService(){return getService(IVSysSiteDomainService.class);}
//
//    public static IContentCarouselService contentCarouselService() {
//        return getService(IContentCarouselService.class);
//    }
//
//    public static IVSysSiteUserService vSysSiteUserService() {
//        return getService(IVSysSiteUserService.class);
//    }
//
//    public static ICompanyUserService companyUserService() {
//        return getService(ICompanyUserService.class);
//    }
//
//    public static ISysParamService sysParamService() {
//        return getService(ISysParamService.class);
//    }
//
//    public static ISysUserService sysUserService() {
//        return getService(ISysUserService.class);
//    }
//
//    public static ISysUserExtendService sysUserExtendService() {
//        return getService(ISysUserExtendService.class);
//    }
//
//    public static ISysSiteService sysSiteService() {
//        return getService(ISysSiteService.class);
//    }
//
//    public static ILotteryBetOrderService lotteryBetOrderService() {
//        return getService(ILotteryBetOrderService.class);
//    }
//
//    public static IPassportService passportService() {
//        return getService(IPassportService.class);
//    }
//
//    public static IOauthClientService oauthClientService() {
//        return getService(IOauthClientService.class);
//    }
//
//    public static IOauthTokenService oauthTokenService() {
//        return getService(IOauthTokenService.class);
//    }
//
//    public static IBankService bankService() {
//        return getService(IBankService.class);
//    }
//
//    public static IUserPlayerService userPlayerService() {
//        return getService(IUserPlayerService.class);
//    }
//
//    public static IBillChangeService billChangeService() {
//        return getService(IBillChangeService.class);
//    }
//
//    public static IUserFeedbackService userFeedbackService() {
//        return getService(IUserFeedbackService.class);
//    }
//    public static IPlayerRankService playerRankService() {
//        return getService(IPlayerRankService.class);
//    }
//
//    public static IBillSalaryRatioService billSalaryRatioService(){return getService(IBillSalaryRatioService.class);}
//
//    public static IBillSalaryProjectService billSalaryProjectService(){return getService(IBillSalaryProjectService.class);}
//
//    public static IBillSalaryGradeService billSalaryGradeService(){return getService(IBillSalaryGradeService.class);}
//
//    public static IBillDividenRatioService billDividenRatioService(){return getService(IBillDividenRatioService.class);}
//
//    public static IBillDividenProjectService billDividenProjectService(){return getService(IBillDividenProjectService.class);}
//
//    public static IBillDividenGradeService billDividenGradeService(){return getService(IBillDividenGradeService.class);}
//
//    public static IBillAuditService billAuditService(){
//        return getService(IBillAuditService.class);
//    }
//
//    public static IBillWithdrawalService billWithdrawalService(){
//        return getService(IBillWithdrawalService.class);
//    }
//
//    public static ILotteryResultNumberService lotteryResultNumberService(){
//        return getService(ILotteryResultNumberService.class);
//    }
//    public static IBillDepositService billDepositService(){
//        return getService(IBillDepositService.class);
//    }
//
//    public static ILotteryBetService lotteryBetService() {
//        return getService(ILotteryBetService.class);
//    }
//
//    public static IAuditService auditService() {
//        return getService(IAuditService.class);
//    }
//
//    public static ISysAuditLogService sysAuditLogService() {
//        return getService(ISysAuditLogService.class);
//    }
//
//    public static ITaskScheduleServiceExGs taskScheduleServiceExGs() {
//        return getService(ITaskScheduleServiceExGs.class);
//    }
//
//    public static ITaskScheduleServiceExS taskScheduleServiceExS() {
//        return getService(ITaskScheduleServiceExS.class);
//    }
//
//    public static IPayAccountService payAccountService() {
//        return getService(IPayAccountService.class);
//    }
//
//    public static IMessageService messageService() {return getService(IMessageService.class);}
//
//    public static INoticeReceiverService noticeReceiverService() {return getService(INoticeReceiverService.class);}
//
//    public static IVTeamMemberService vTeamMemberService() {
//        return getService(IVTeamMemberService.class);
//    }
//
//    public static IOnlinePayService onlinePayService() {
//        return getService(IOnlinePayService.class);
//    }
//
//    public static IReportGameService reportGameService() {
//        return getService(IReportGameService.class);
//    }
//
//    public static IReportPlayerService reportPlayerService() {
//        return getService(IReportPlayerService.class);
//    }
//
//    public static IReportGameMerchantService reportGameMerchantService(){
//        return getService(IReportGameMerchantService.class);
//    }
//    public static IOperationActivityService operationActivityService() {
//        return getService(IOperationActivityService.class);
//    }
//    public static IContentMessageService contentMessageService() {
//        return getService(IContentMessageService.class);
//    }
//
//    public static IContentMessageReceiveService contentMessageReceiveService() {
//        return getService(IContentMessageReceiveService.class);
//    }
//
//    public static IContentDocumentService contentDocumentService() {
//        return getService(IContentDocumentService.class);
//    }
//
//    public static IAppUpdateService appUpdateService() {
//        return getService(IAppUpdateService.class);
//    }
//
//    public static ILotteryService lotteryService() {
//        return getService(ILotteryService.class);
//    }
//
//    public static IAppLogService appLogService() {
//        return getService(IAppLogService.class);
//    }
//
//    public static IUserPlayerTransferService userPlayerTransferService() {
//        return getService(IUserPlayerTransferService.class);
//    }
//
//    public static ISysDomainService sysDomainService() {
//        return getService(ISysDomainService.class);
//    }
//
//    public static IBillSalaryService billSalaryService() {
//        return getService(IBillSalaryService.class);
//    }
//
//    public static IBillDividenService billDividenService() {
//        return getService(IBillDividenService.class);
//    }
//
//    public static INoticeService noticeService() {
//        return getService(INoticeService.class);
//    }
//
//    public static ISiteSysParamService siteSysParamService() {
//        return getService(ISiteSysParamService.class);
//    }
//
//    public static ISysRoleService sysRoleService(){
//        return getService(ISysRoleService.class);
//    }
//
//    public static IVSiteMasterManageService vSiteMasterManageService() {
//        return getService(IVSiteMasterManageService.class);
//    }
//
//    public static IImportQjService iImportQjService(){
//        return getService(IImportQjService.class);
//    }
//
//    public static ISiteConfineAreaService siteConfineAreaService() {
//        return getService(ISiteConfineAreaService.class);
//    }
//
//    /**
//     * 返回限制/允许访问站点/管理中心的IP表远程服务实INoticeTmplService例
//     *
//     * @return 限制/允许访问站点/管理中心的IP表远程服务实例
//     */
//    public static ISiteConfineIpService siteConfineIpService() {
//        return getService(ISiteConfineIpService.class);
//    }
//
//    /**
//     * 返回站点语言表远程服务实例
//     *
//     * @return 站点语言表远程服务实例
//     */
//    public static ISiteLanguageService siteLanguageService() {
//        return getService(ISiteLanguageService.class);
//    }
//
//    /**
//     * 平台公告 2018年03月23日13:44:34
//     */
//    public static ISystemAnnouncementService sysAnnouncementService(){return getService(ISystemAnnouncementService.class);}
//
//    /**
//     * 返回站点国际化远程服务实例
//     *
//     * @return 站点国际化远程服务实例
//     */
//    public static ISiteI18nService siteI18nService() {
//        return getService(ISiteI18nService.class);
//    }
//
//    /**
//     * 返回通知模板远程服务实例
//     *
//     * @return 通知模板远程服务实例
//     */
//    public static INoticeTmplService noticeTmplService() {
//        return getService(INoticeTmplService.class);
//    }
//
//    /**
//     * 返回信息模板内容参数表远程服务实例
//     *
//     * @return 信息模板内容参数表远程服务实例
//     */
//    public static INoticeParamRelationService noticeParamRelationService() {
//        return getService(INoticeParamRelationService.class);
//    }
//
//    /**
//     * 返回子账户视图远程服务实例
//     *
//     * @return 子账户视图远程服务实例
//     */
//    public static IVSubAccountService vSubAccountService() {
//        return getService(IVSubAccountService.class);
//    }
//
//    public static IMyAccountService myAccountService() {
//        return getService(IMyAccountService.class);
//    }
//
//    public static ISysUserRoleService sysUserRoleService() {
//        return getService(ISysUserRoleService.class);
//    }
//
//    public static IVSiteUserAccountService vSiteUserAccountService() {
//        return getService(IVSiteUserAccountService.class);
//    }
//
//    public static ISiteCurrencyService siteCurrencyService() {
//        return getService(ISiteCurrencyService.class);
//    }
//
//    public static ILotteryHandicapService lotteryHandicapService() {
//        return getService(ILotteryHandicapService.class);
//    }
//
//    public static ILotteryRuleService lotteryRuleService() {
//        return getService(ILotteryRuleService.class);
//    }
//
//    public static ILotteryQuotaSetService lotteryQuotaSetService() {
//        return getService(ILotteryQuotaSetService.class);
//    }
//
//
//    public static ILotteryOddSetService lotteryOddSetService() {
//        return getService(ILotteryOddSetService.class);
//    }
//
//    public static ILotteryTypeService lotteryTypeService() {
//        return getService(ILotteryTypeService.class);
//    }
//
//    public static IPayAccountCollectionService payAccountCollectionService() {
//        return getService(IPayAccountCollectionService.class);
//    }
//
//    public static IPayWarningService payWarningService() {
//        return getService(IPayWarningService.class);
//    }
//
//    public static IPayRankService payRankService() {
//        return getService(IPayRankService.class);
//    }
//
//    public static IVPayAccountService vPayAccountService() {
//        return getService(IVPayAccountService.class);
//    }
//
//
//    public static IVPlayerRankStatisticsService vPlayerRankStatisticsService() {
//        return getService(IVPlayerRankStatisticsService.class);
//    }
//
//    public static IPayAccountCurrencyService payAccountCurrencyService() {
//        return getService(IPayAccountCurrencyService.class);
//    }
//
//    /**
//     * 备注表
//     */
//    public static IRemarkService remarkService() {
//        return getService(IRemarkService.class);
//    }
//
//    public static ISiteAppUpdateService siteAppUpdateService() {
//        return getService(ISiteAppUpdateService.class);
//    }
//
//    public static ISiteAppUpdateService searchInitSite() {
//        return getService(ISiteAppUpdateService.class);
//    }
//
//    public static IAppVersionLogService appVersionLogService(){
//        return getService(IAppVersionLogService.class);
//    }
//
//    /**
//     * 返回银行扩展表远程服务实例
//     *
//     * @return
//     */
//    public static IBankExtendService bankExtendService() {
//        return getService(IBankExtendService.class);
//    }
//
//    /**
//     * 返回浮动图子项表远程服务实例
//     *
//     * @return 浮动图子项表远程服务实例
//     */
//    public static ICttFloatPicItemService cttFloatPicItemService() {
//        return getService(ICttFloatPicItemService.class);
//    }
//
//    public static ICttFloatPicService cttFloatPicService() {
//        return getService(ICttFloatPicService.class);
//    }
//
//    public static IBillRakebackService billRakebackService() {
//        return getService(IBillRakebackService.class);
//    }
//
//    public static IVBillRakebackService vBillRakebackService() {
//        return getService(IVBillRakebackService.class);
//    }
//
//    public static IVBillChangeService vBillChangeService() {
//        return getService(IVBillChangeService.class);
//    }
//
//    public static IReportOperateService reportOperateService() {
//        return getService(IReportOperateService.class);
//    }
//
//    public static IReportBillService reportBillService() {
//        return getService(IReportBillService.class);
//    }
//
//
//    public static ISystemMessageService systemMessageService() {
//        return getService(ISystemMessageService.class);
//    }
//
//    public static ISysExportService sysExportService() {
//        return getService(ISysExportService.class);
//    }
//
//    public static IRakebackSetService rakebackSetService(){return getService(IRakebackSetService.class);}
//
//    public static IUserPlayerImportService userPlayerImportService() {
//        return getService(IUserPlayerImportService.class);
//    }
//
//    public static IVUserPlayerImportService vUserPlayerImportService() {
//        return getService(IVUserPlayerImportService.class);
//    }
//
//    public static ILotteryErrorLogService lotteryErrorLogService() {
//        return getService(ILotteryErrorLogService.class);
//    }
//
//    public static IVSysDomainService vSysDomainService() {
//        return getService(IVSysDomainService.class);
//    }
//
//    public static ILotteryGatherConfService lotteryGatherConfService() {
//        return getService(ILotteryGatherConfService.class);
//    }
//
//    public static ISysDatasourceService sysDatasourceService() {
//        return getService(ISysDatasourceService.class);
//    }
//
//    /**
//     * 返回玩家盈利排行榜表远程服务实例
//     *
//     * @return 玩家盈利排行榜表远程服务实例
//     */
//    public static IPlayerProfitService playerProfitService() { return getService(IPlayerProfitService.class);}
//
//    /**
//     * 返回任务表远程服务实例
//     *
//     * @return 任务表远程服务实例
//     */
//    public static IVTaskReminderService userTaskReminderService() { return getService(IVTaskReminderService.class);}
//
//    /**
//     * 返回远程服务实例
//     *
//     * @return 远程服务实例
//     */
//    public static so.wwb.lotterybox.iservice.merchant.change.IImportYiboService importYiboService() {
//        return getService(so.wwb.lotterybox.iservice.merchant.change.IImportYiboService.class);
//    }
//
//    /**
//     * 返回远程服务实例
//     *
//     * @return 远程服务实例
//     */
//    public static so.wwb.lotterybox.iservice.merchant.change.IImportLixinService importLixinService() {
//        return getService(so.wwb.lotterybox.iservice.merchant.change.IImportLixinService.class);
//    }
//
//    /**
//     * 玩家vip设置服务
//     * @return
//     */
//    public static IPlayerVipSetService playerVipSetService() {
//        return getService(IPlayerVipSetService.class);
//    }
//
//    /**
//     * 用户备注服务实例
//     * @return
//     */
//    public static IUserRemarkService userRemarkService() {
//        return getService(IUserRemarkService.class);
//    }
//
//    /**
//     * 自主彩开号记录服务
//     */
//    public static ILotteryResultLogService lotteryResultLogService() {
//        return getService(ILotteryResultLogService.class);
//    }
//    public static IVPlayerTeamService vPlayerTeamService() {
//        return getService(IVPlayerTeamService.class);
//    }
//
//
//    /**
//     * 站点分组
//     */
//    public static ISysSiteGroupService sysSiteGroupService() {
//        return getService(ISysSiteGroupService.class);
//    }
//
//    public static IAppErrorLogService AppErrorLogService() {
//        return getService(IAppErrorLogService.class);
//    }

}
