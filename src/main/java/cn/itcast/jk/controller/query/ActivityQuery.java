package cn.itcast.jk.controller.query;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.jk.controller.query.BaseQuery;

public class ActivityQuery extends BaseQuery{
	private Integer num;
	public Integer getNum() {
		return num;
	}
	public ActivityQuery setNum(Integer num) {
		this.num = num;
		return this;
	}

	private String type;
	public String getType() {
		return type;
	}
	public ActivityQuery setType(String type) {
		this.type = type;
		return this;
	}
	private boolean typeLike;
	public ActivityQuery setTypeLike(boolean isLike) {
		this.typeLike = isLike;
		return this;
	}

	private String theme;
	public String getTheme() {
		return theme;
	}
	public ActivityQuery setTheme(String theme) {
		this.theme = theme;
		return this;
	}
	private boolean themeLike;
	public ActivityQuery setThemeLike(boolean isLike) {
		this.themeLike = isLike;
		return this;
	}

	private String time;
	public String getTime() {
		return time;
	}
	public ActivityQuery setTime(String time) {
		this.time = time;
		return this;
	}
	private boolean timeLike;
	public ActivityQuery setTimeLike(boolean isLike) {
		this.timeLike = isLike;
		return this;
	}

	private String place;
	public String getPlace() {
		return place;
	}
	public ActivityQuery setPlace(String place) {
		this.place = place;
		return this;
	}
	private boolean placeLike;
	public ActivityQuery setPlaceLike(boolean isLike) {
		this.placeLike = isLike;
		return this;
	}
	private String state;
	public String getState() {
		return state;
	}
	public ActivityQuery setState(String state) {
		this.state = state;
		return this;
	}
	private boolean stateLike;
	public ActivityQuery setStateLike(boolean isLike) {
		this.stateLike = isLike;
		return this;
	}

	private List<OrderField> orderFields = new ArrayList<OrderField>();
	public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}
}
