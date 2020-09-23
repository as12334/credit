package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import so.wwb.lotterybox.model.enums.sys.DomainPageUrlEnum;


/**
 * 域名视图实体
 *
 * @author bruce
 * @time 2017-5-1 11:52:43
 */
//region your codes 1
public class VSysDomain implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
    private static final long serialVersionUID = 7827593741111001019L;
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
	public static final String PROP_PARENT_ID = "parentId";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_TYPE = "type";
	public static final String PROP_USER_CODE = "userCode";
	public static final String PROP_OWNER_NAME = "ownerName";

	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 用户id */
	private Integer sysUserId;
	/** 域名地址 */
	private String domain;
	/** 是否默认 */
	private Boolean isDefault;
	/** 是否启用 */
	private Boolean isEnable;
	/** 是否删除 */
	private Boolean isDeleted;
	/** 排序 */
	private Integer sort;
	/** siteid */
	private Integer siteId;
	/** 系统标识 */
	private String subsysCode;
	/** 创建用户 */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新用户 */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	/**  */
	private Boolean isForAllRank;
	/** 指向地址 */
	private String pageUrl;
	/** 名称 */
	private String name;
	/**  */
	private String resolveStatus;
	/**  */
	private Boolean buildIn;
	/**  */
	private Boolean isTemp;
	/**  */
	private String code;
	/** siteId上一级 */
	private Integer parentId;
	/**  */
	private String username;
	/**  */
	private String type;

	private String userCode;

	private String isTimeOut;
	private String ownerName;
	//endregion

	
	//region constuctors
	public VSysDomain(){
	}

	public VSysDomain(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	@org.soul.model.common.Sortable
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}
	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
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

	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer value) {
		this.parentId = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getTimeOut() {
		return isTimeOut;
	}

	public void setTimeOut(String timeOut) {
		isTimeOut = timeOut;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	//endregion your codes 2

}