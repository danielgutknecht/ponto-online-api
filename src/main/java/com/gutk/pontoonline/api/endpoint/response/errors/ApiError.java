package com.gutk.pontoonline.api.endpoint.response.errors;

import java.time.OffsetDateTime;
import java.util.List;

public class ApiError {
	
	//@ApiModelProperty(example = "400", position = 1)
	private Integer status;
	
	//@ApiModelProperty(example = "2020-01-16T13:45:00.70844Z", position = 5)
	private OffsetDateTime timestamp;
	
	//@ApiModelProperty(example = "https://algafood.com.br/dados-invalidos", position = 10)
	private String type;
	
	//@ApiModelProperty(example = "Dados inválidos", position = 15)
	private String title;
	
	//@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 20)
	private String detail;
	
	//@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 25)
	private String userMessage;
	
	//@ApiModelProperty(value = "Lista de objetos ou campos que geraram erro (opcional)", position = 30)
	private List<Object> objects;


	private ApiError() {
	}

	public ApiError(Integer status, OffsetDateTime timestamp, String type, String title, String detail, String userMessage, List<Object> objects) {
		this.status = status;
		this.timestamp = timestamp;
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.userMessage = userMessage;
		this.objects = objects;
	}

	public Integer getStatus() {
		return status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public List<Object> getObjects() {
		return objects;
	}



	//@ApiModel("ObjetoProblema"
	//@Builder
	public static class Object {

		//@ApiModelProperty(example = "nome")
		private String name;

		//@ApiModelProperty(example = "O campo nome é obrigatório")
		private String userMessage;

		public String getName() {
			return name;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public static final class Builder {
			//@ApiModelProperty(example = "400", position = 1)
			private String name;
			//@ApiModelProperty(example = "2020-01-16T13:45:00.70844Z", position = 5)
			private String userMessage;

			public Builder() {
			}

			public Builder(String name, String userMessage) {
				this.name = name;
				this.userMessage = userMessage;
			}

			public static Builder newBuilder() {
				return new Builder();
			}

			public Builder name(String name) {
				this.name = name;
				return this;
			}

			public Builder userMessage(String userMessage) {
				this.userMessage = userMessage;
				return this;
			}

			/*
			public ApiError build() {
				ApiError apiError = new ApiError();
				apiError. = this.name;
				apiError.userMessage = this.userMessage;
				return apiError;
			}*/
			public Object build() {
				Object object = new Object();
				object.name = this.name;
				object.userMessage = this.userMessage;

				return object;
			}
		}
	}

	public static final class Builder {
		//@ApiModelProperty(example = "400", position = 1)
		private Integer status;
		//@ApiModelProperty(example = "2020-01-16T13:45:00.70844Z", position = 5)
		private OffsetDateTime timestamp;
		//@ApiModelProperty(example = "https://algafood.com.br/dados-invalidos", position = 10)
		private String type;
		//@ApiModelProperty(example = "Dados inválidos", position = 15)
		private String title;
		//@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 20)
		private String detail;
		//@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 25)
		private String userMessage;
		//@ApiModelProperty(value = "Lista de objetos ou campos que geraram erro (opcional)", position = 30)
		private List<Object> objects;

		private Builder() {
		}

		public static Builder newbuilder() {
			return new Builder();
		}

		public Builder status(Integer status) {
			this.status = status;
			return this;
		}

		public Builder timestamp(OffsetDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder userMessage(String userMessage) {
			this.userMessage = userMessage;
			return this;
		}

		public Builder objects(List<Object> objects) {
			this.objects = objects;
			return this;
		}

		public ApiError build() {
			return new ApiError(status, timestamp, type, title, detail, userMessage, objects);
		}
	}
}
