package by.belinvest.panel.admin.product.service.model;

import java.math.BigDecimal;

public class Fine {

    private String dateFine;
    private BigDecimal sumFine;
    private String termFine;
    private String typeTermFine;

    public static final class Builder {

        private String dateFine;
        private BigDecimal sumFine;
        private String termFine;
        private String typeTermFine;

        private Builder() {}

        public static Builder aFine() { return new Builder(); }

        public Builder dateFine(String dateFine) {
            this.dateFine = dateFine;
            return this;
        }

        public Builder sumFine(BigDecimal sumFine) {
            this.sumFine = sumFine;
            return this;
        }

        public Builder termFine(String termFine) {
            this.termFine = termFine;
            return this;
        }

        public Builder typeTermFine(String typeTermFine) {
            this.typeTermFine = typeTermFine;
            return this;
        }

        public Fine build() {
            Fine fine = new Fine();
            fine.termFine = this.termFine;
            fine.dateFine = this.dateFine;
            fine.sumFine = this.sumFine;
            fine.typeTermFine = this.typeTermFine;
            return fine;
        }

    }

}
