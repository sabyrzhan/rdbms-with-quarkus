package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public abstract class PanacheEntityBuilderEnabler extends PanacheEntity {
    public static abstract class PanacheEntityBuilderEnablerBuilder<C extends PanacheEntityBuilderEnabler, B extends PanacheEntityBuilderEnablerBuilder<C, B>> {
        private Long id;

        public B id(Long id) {
            this.id = id;
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }

    protected PanacheEntityBuilderEnabler(PanacheEntityBuilderEnablerBuilder<?, ?> b) {
        super();
        this.id = b.id;
    }

    protected PanacheEntityBuilderEnabler() {

    }
}
