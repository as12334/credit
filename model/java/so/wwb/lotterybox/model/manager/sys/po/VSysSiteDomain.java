package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;
import so.wwb.lotterybox.model.enums.base.MaintainTypeEnum;
import so.wwb.lotterybox.model.enums.sys.SysSiteStatusEnum;

import java.util.Date;

//region your codes 1
public class VSysSiteDomain implements IEntity<Integer> {
//endregion your codes 1

    //region your codes 3
    private static final long serialVersionUID = 204233763713118267L;
    //endregion your codes 3

    //region property name constants
    public static final String PROP_ID = "id";
    public static final String PROP_DOM_NAME = "domName";
    public static final String PROP_SITE_ID = "siteId";
    public static final String PROP_NAME = "name";
    public static final String PROP_SITE_USER_ID = "siteUserId";
    public static final String PROP_SITE_USER_NAME = "siteUserName";
    public static final String PROP_SITE_USER_CODE = "siteUserCode";
    public static final String PROP_SITE_USER_OWNER_CODE = "siteUserOwnerCode";
    public static final String PROP_DOMAIN_ID = "domainId";
    public static final String PROP_DOMAIN = "domain";
    public static final String PROP_DOMAIN_USER_ID = "domainUserId";
    public static final String PROP_DOMAIN_USER_NAME = "domainUserName";
    public static final String PROP_DOMAIN_USER_CODE = "domainUserCode";
    public static final String PROP_TIME_ZONE = "timeZone";
    public static final String PROP_SITE_LOCALE = "siteLocale";
    public static final String PROP_SITE_CODE = "siteCode";
    public static final String PROP_PLATFORM_CATEGORY = "platformCategory";
    public static final String PROP_LOGO_PATH = "logoPath";
    public static final String PROP_SITE_PARENT_ID = "siteParentId";
    public static final String PROP_SITE_STATUS = "siteStatus";
    public static final String PROP_MAINTAIN_START_TIME = "maintainStartTime";
    public static final String PROP_MAINTAIN_END_TIME = "maintainEndTime";
    public static final String PROP_MAINTAIN_REASON = "maintainReason";
    public static final String PROP_TEMPLATE_CODE = "templateCode";
    public static final String PROP_PAGE_URL = "pageUrl";
    public static final String PROP_IS_DEFAULT = "isDefault";
    public static final String PROP_IS_ENABLE = "isEnable";
    public static final String PROP_IS_DELETED = "isDeleted";
    public static final String PROP_IS_TEMP = "isTemp";
    public static final String PROP_RESOLVE_STATUS = "resolveStatus";
    public static final String PROP_CREATE_TIME = "createTime";
    public static final String PROP_SITE_SUBSYS_CODE = "siteSubsysCode";
    public static final String PROP_DOMAIN_SUBSYS_CODE = "domainSubsysCode";
    public static final String PROP_DOMAIN_USER_TYPE = "domainUserType";
    public static final String PROP_SITE_USER_TYPE = "siteUserType";
    public static final String PROP_TYPE = "type";
    public static final String PROP_MODE = "mode";
    public static final String PROP_SSL_ENABLED = "sslEnabled";
    public static final String PROP_OWNER_ID = "ownerId";
    public static final String PROP_THEME = "theme";
    public static final String PROP_TITLE = "title";

    //endregion

    //region properties
    /**  */
    private Integer id;
    /**  */
    private String domName;
    /**  */
    private Integer siteId;
    /**  */
    private String name;
    /**  */
    private Integer siteUserId;
    /**  */
    private String siteUserName;
    /**  */
    private String siteUserCode;
    /**  */
    private String siteUserOwnerCode;
    /**  */
    private Integer domainId;
    /**  */
    private String domain;
    /**  */
    private Integer domainUserId;
    /**  */
    private String domainUserName;
    /**  */
    private String domainUserCode;
    /**  */
    private String timeZone;
    /**  */
    private String siteLocale;
    /**  */
    private String siteCode;
    /**  */
    private String platformCategory;
    /**  */
    private String logoPath;
    /**  */
    private Integer siteParentId;
    /**  */
    private String siteStatus;
    /**  */
    private Date maintainStartTime;
    /**  */
    private Date maintainEndTime;
    /**  */
    private String maintainReason;
    /**  */
    private String templateCode;
    /**  */
    private String pageUrl;
    /**  */
    private Boolean isDefault;
    /**  */
    private Boolean isEnable;
    /**  */
    private Boolean isDeleted;
    /**  */
    private Boolean isTemp;
    /**  */
    private String resolveStatus;
    /**  */
    private Date createTime;
    /** SSL是否启用 **/
    private Boolean sslEnabled;

    private String siteSubsysCode;
    private String domainSubsysCode;
    private String domainUserType;
    private String siteUserType;
    private String isTimeOut;
    private String mode;
    /**
     * 域名类型：1-管理中心 2-游戏中心 3-开放中心-API 3-商户回调
     */
    private String type;

    /**  */
    private Integer ownerId;

    /**
     * parentIds
     */
    private String parentIds;

    private String subsysCode;
    private Integer agentId;
    private String theme;
    private String title;
    //endregion

    //region constuctors
    public VSysSiteDomain() {
    }

    public VSysSiteDomain(Integer id) {
        this.id = id;
    }
    //endregion

    //region getters and setters
    public String getTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(String timeOut) {
        isTimeOut = timeOut;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getDomName() {
        return domName;
    }

    public void setDomName(String domName) {
        this.domName = domName;
    }

    public Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(Integer value) {
        this.siteId = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Integer getSiteUserId() {
        return this.siteUserId;
    }

    public void setSiteUserId(Integer value) {
        this.siteUserId = value;
    }

    public String getSiteUserName() {
        return this.siteUserName;
    }

    public void setSiteUserName(String value) {
        this.siteUserName = value;
    }

    public String getSiteUserCode() {
        return this.siteUserCode;
    }

    public void setSiteUserCode(String value) {
        this.siteUserCode = value;
    }

    public String getSiteUserOwnerCode() {
        return this.siteUserOwnerCode;
    }

    public void setSiteUserOwnerCode(String value) {
        this.siteUserOwnerCode = value;
    }

    public Integer getDomainId() {
        return this.domainId;
    }

    public void setDomainId(Integer value) {
        this.domainId = value;
    }

    public String getDomain() {
        if (this.domain == null)
            return "";
        return this.domain;
    }

    public void setDomain(String value) {
        this.domain = value;
    }

    public Integer getDomainUserId() {
        return this.domainUserId;
    }

    public void setDomainUserId(Integer value) {
        this.domainUserId = value;
    }

    public String getDomainUserName() {
        return this.domainUserName;
    }

    public void setDomainUserName(String value) {
        this.domainUserName = value;
    }

    public String getDomainUserCode() {
        return this.domainUserCode;
    }

    public void setDomainUserCode(String value) {
        this.domainUserCode = value;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    public String getSiteLocale() {
        return this.siteLocale;
    }

    public void setSiteLocale(String value) {
        this.siteLocale = value;
    }

    public String getSiteCode() {
        return this.siteCode;
    }

    public void setSiteCode(String value) {
        this.siteCode = value;
    }

    public String getPlatformCategory() {
        return this.platformCategory;
    }

    public void setPlatformCategory(String value) {
        this.platformCategory = value;
    }

    public String getLogoPath() {
        return this.logoPath;
    }

    public void setLogoPath(String value) {
        this.logoPath = value;
    }

    public Integer getSiteParentId() {
        return this.siteParentId;
    }

    public void setSiteParentId(Integer value) {
        this.siteParentId = value;
    }

    public String getSiteStatus() {
        return this.siteStatus;
    }

    public void setSiteStatus(String value) {
        this.siteStatus = value;
    }

    public Date getMaintainStartTime() {
        return this.maintainStartTime;
    }

    public void setMaintainStartTime(Date value) {
        this.maintainStartTime = value;
    }

    public Date getMaintainEndTime() {
        return this.maintainEndTime;
    }

    public void setMaintainEndTime(Date value) {
        this.maintainEndTime = value;
    }

    public String getMaintainReason() {
        return this.maintainReason;
    }

    public void setMaintainReason(String value) {
        this.maintainReason = value;
    }

    public String getTemplateCode() {
        return this.templateCode;
    }

    public void setTemplateCode(String value) {
        this.templateCode = value;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public void setPageUrl(String value) {
        this.pageUrl = value;
    }

    public Boolean getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Boolean value) {
        this.isDefault = value;
    }

    public Boolean getIsEnable() {
        return this.isEnable;
    }

    public void setIsEnable(Boolean value) {
        this.isEnable = value;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean value) {
        this.isDeleted = value;
    }

    public Boolean getIsTemp() {
        return this.isTemp;
    }

    public void setIsTemp(Boolean value) {
        this.isTemp = value;
    }

    public String getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(String value) {
        this.resolveStatus = value;
    }

    @Sortable
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date value) {
        this.createTime = value;
    }

    public String getSiteSubsysCode() {
        return siteSubsysCode;
    }

    public void setSiteSubsysCode(String siteSubsysCode) {
        this.siteSubsysCode = siteSubsysCode;
    }

    public String getDomainSubsysCode() {
        return domainSubsysCode;
    }

    public void setDomainSubsysCode(String domainSubsysCode) {
        this.domainSubsysCode = domainSubsysCode;
    }

    public String getDomainUserType() {
        return domainUserType;
    }

    public void setDomainUserType(String domainUserType) {
        this.domainUserType = domainUserType;
    }

    public String getSiteUserType() {
        return siteUserType;
    }

    public void setSiteUserType(String siteUserType) {
        this.siteUserType = siteUserType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getSubsysCode() {
        return subsysCode;
    }

    public void setSubsysCode(String subsysCode) {
        this.subsysCode = subsysCode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getSslEnabled() {
        return sslEnabled;
    }

    public void setSslEnabled(Boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }
//endregion

    //region your codes 2
    public void calStatus(VSysSiteDomain sysSiteDomain) {

        if (!MaintainTypeEnum.API_CENTER.getCode().equals(sysSiteDomain.getType())) {
        } else {
        }
    }


    private void setOtherSiteStatus() {
        Date now = new Date();
        if (SysSiteStatusEnum.MAINTAIN.getCode().equals(getSiteStatus())) {
            if (getMaintainStartTime() != null) {
                if (now.before(getMaintainStartTime())) {
                    this.setSiteStatus(SysSiteStatusEnum.PRE_MAINTAIN.getCode());
                } else {
                    //this.setSiteStatus(SysSiteStatusEnum.MAINTAIN.getCode());
                    if (getMaintainEndTime() != null) {
                        if (now.before(getMaintainEndTime())) {
                            this.setSiteStatus(SysSiteStatusEnum.MAINTAIN.getCode());
                        } else {
                            this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
                        }
                    } else {
                        this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
                    }
                }
            } else {
                //返回原值
                this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
            }
        }
    }

    public static final String PROP_LOWER_DOMAIN = "lowerDomain";

    public String getLowerDomain() {
        return getDomain().toLowerCase();
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //endregion your codes 2
}