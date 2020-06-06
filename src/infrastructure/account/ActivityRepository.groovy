package infrastructure.account

import domain.account.activity.Activity

interface ActivityRepository {
    save(Activity activity)
}
