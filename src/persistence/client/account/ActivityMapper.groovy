package persistence.account

import domain.client.account.activity.Activity
import infrastructure.shared.Mapper

class ActivityMapper implements Mapper<Activity, persistence.account.model.Activity> {
    @Override
    persistence.account.model.Activity map(Activity obj) {
        return null
    }

    @Override
    Activity map(persistence.account.model.Activity sObj) {
        return null
    }
}
