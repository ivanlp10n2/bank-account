package infrastructure.account

import domain.account.Account
import domain.account.AccountRepository
import domain.account.activity.Activity
import persistence.Database
import persistence.NoSQLDatabase
import persistence.account.AccountPogoMapper
import persistence.shared.PogoMapper
import persistence.shared.Serializer

class AccountRepositoryImpl implements AccountRepository {

    private final Database db
    private final PogoMapper mapper
    private final ActivityRepository activityRepository

    AccountRepositoryImpl(){
        db = NoSQLDatabase.getInstance()
        mapper = new AccountPogoMapper()
        activityRepository = new ActivityRepositoryImpl()
    }


    @Override
    Account find(Account.AccountId identifier) {
        String id = Serializer.serialize(identifier)
        Account account = mapper.map(
                                db.find(id))
        assert validateIntegrity(account)
        account
    }

    @Override
    void add(Account obj) {

    }

    Boolean validateIntegrity(Account account) {
        account
    }

    @Override
    void updateActivities(Account account) {
        account.activities.each { Activity activity ->
            if (!activity.id)
                activityRepository.save(mapper.map(activity))
        }
    }
}
