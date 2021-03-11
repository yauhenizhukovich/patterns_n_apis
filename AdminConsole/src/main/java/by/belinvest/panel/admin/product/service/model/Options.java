package by.belinvest.panel.admin.product.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {

    private String optionView;
    private boolean optionValue;
    private String optionId;

    public Options(String optionView, boolean optionValue, String optionId) {
        this.optionView = optionView;
        this.optionValue = optionValue;
        this.optionId = optionId;
    }

    public String getOptionView() {
        return optionView;
    }

    public void setOptionView(String optionView) {
        this.optionView = optionView;
    }

    public boolean isOptionValue() {
        return optionValue;
    }

    public void setOptionValue(boolean optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public Options() {
    }

    public static final class Builder {

        private String optionView;
        private boolean optionValue;
        private String optionId;

        private Builder() {}

        public static Builder anOptions() { return new Builder(); }

        public Builder optionView(String optionView) {
            this.optionView = optionView;
            return this;
        }

        public Builder optionValue(boolean optionValue) {
            this.optionValue = optionValue;
            return this;
        }

        public Builder optionId(String optionId) {
            this.optionId = optionId;
            return this;
        }

        public Options build() {
            Options options = new Options();
            options.optionView = this.optionView;
            options.optionValue = this.optionValue;
            options.optionId = this.optionId;
            return options;
        }

    }

}
