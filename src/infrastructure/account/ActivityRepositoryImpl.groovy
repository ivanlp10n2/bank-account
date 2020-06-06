package infrastructure.account

import domain.account.activity.Activity
import persistence.Database
import persistence.NoSQLDatabase
import persistence.account.ActivityPogoMapper
import persistence.shared.PogoMapper

class ActivityRepositoryImpl implements ActivityRepository{

    private final Database db
    private final PogoMapper mapper

    ActivityRepositoryImpl(){
        db = NoSQLDatabase.getInstance()
        mapper = new ActivityPogoMapper()
    }

    @Override
    def save(Activity activity) {
        activity.id
    }
}
