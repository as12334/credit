package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.common.Sortable;
import so.wwb.lotterybox.model.enums.sys.DomainPageUrlEnum;


/**
 * 域名表实体
 *
 * @author jerry
 * @tableAuthor Longer
 * @time 2017-4-26 8:39:16
 */
//region your codes 1
public class SysDomain implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
    private static final long serialVersionUID = 5967350233645526228L;
    //endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_DOMAIN = "domain";
	public static final String PROP_IS_DEFAULT = "isDefault";
	public static final String PROP_IS_ENABLE = "isEnable";
	public static final String PROP_IS_DELETED = "isDeleted";
	public static final String PROP_SORT = "sort";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_IS_FOR_ALL_RANK = "isForAllRank";
	public static final String PROP_PAGE_URL = "pageUrl";
	public static final String PROP_NAME = "name";
	public static final String PROP_RESOLVE_STATUS = "resolveStatus";
	public static final String PROP_BUILD_IN = "buildIn";
	public static final String PROP_IS_TEMP = "isTemp";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_OWNER_ID = "ownerId";
	public static final String PROP_TEMPLATE_CODE = "templateCode";
	public static final String PROP_THEME = "theme";
	public static final String PROP_OWNER_NAME = "ownerName";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 域名所属的主账号的用户ID,关联sys_user_extend.id 且用户类型为:[0,1,2,22] */
	private Integer sysUserId;
	/** 域名 */
	private String domain;
	/** 是否默认 */
	private Boolean isDefault;
	/** 是否有效 */
	private Boolean isEnable;
	/** 是否删除 */
	private Boolean isDeleted;
	/** 排序号 */
	private Integer sort;
	/** 站点ID */
	private Integer siteId;
	/** 子系统编号:boss:总控,shareholder:股东,merchant:商户,agent:代理(站长),pcenter:游戏中心,api:开放平台,api-call:商户回调 */
	private String subsysCode;
	/** 创建用户ID */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新用户ID */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 是否适用全部层级 */
	private Boolean isForAllRank;
	/** 页面地址 */
	private String pageUrl;
	/** 名称 */
	private String name;
	/** 域名绑定状态:1 待绑定，2绑定中，3待解绑，4解绑中，5完成，6失败 */
	private String resolveStatus;
	/** 是否内置:开发使用 */
	private Boolean buildIn;
	/** 是否是临时域名 */
	private Boolean isTemp;
	/** 识别码，跟域名审核表code一致 */
	private String code;
	/** 1.管理中心、2.游戏中心、3.开放中心(api)、4.商户回调 */
	private String type;
	/** 总代或代理ＩＤ*/
	private Integer ownerId;
	/**总代或代理名称*/
	private String ownerName;
	/**
	 * 模板名称
	 */
	private String templateCode;
	private String theme;


	//endregion

	
	//region constuctors
	public SysDomain(){
	}

	public SysDomain(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String value) {
		this.domain = value;
	}
	@Sortable
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
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String value) {
		this.subsysCode = value;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	@Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer value) {
		this.updateUser = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public Boolean getIsForAllRank() {
		return this.isForAllRank;
	}

	public void setIsForAllRank(Boolean value) {
		this.isForAllRank = value;
	}
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	public String getResolveStatus() {
		return this.resolveStatus;
	}

	public void setResolveStatus(String value) {
		this.resolveStatus = value;
	}
	public Boolean getBuildIn() {
		return this.buildIn;
	}

	public void setBuildIn(Boolean value) {
		this.buildIn = value;
	}
	public Boolean getIsTemp() {
		return this.isTemp;
	}

	public void setIsTemp(Boolean value) {
		this.isTemp = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	//endregion

	//region your codes 2
    /*pageUrl指向枚举code*/
    private String pageUrlCode;

    @Nonpersistent
    public String getPageUrlCode() {
        try {
            DomainPageUrlEnum pageUrlEnum = DomainPageUrlEnum.getDomainPageUrlEnumByCode(pageUrl);
            if (pageUrlEnum == null) {
                return "";
            }
            return pageUrlEnum.getCode();
        } catch (Exception e) {
            return "";
        }

    }

    public void setPageUrlCode(String pageUrlCode) {
        this.pageUrlCode = pageUrlCode;
    }

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	//endregion your codes 2

}