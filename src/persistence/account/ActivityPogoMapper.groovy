package persistence.account

import domain.account.activity.Activity
import persistence.account.pogo.ActivityPogo
import persistence.shared.PogoMapper

class ActivityPogoMapper implements PogoMapper<Activity, ActivityPogo> {
    @Override
    Activity map(ActivityPogo obj) {
        return null
    }
}
