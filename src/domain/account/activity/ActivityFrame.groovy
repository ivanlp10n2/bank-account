package domain.account.activity

import domain.account.Account
import domain.account.money.Money

class ActivityFrame {
    private final List<Activity> activities

    private ActivityFrame(List<Activity> activities){
        this.activities = activities
    }

    static class Factory{
        static ActivityFrame from(List<Activity> activities){
            assert activities
            new ActivityFrame(activities)
        }
    }

    Money calculateBalance(Account.AccountId accountId){
        Money despositBalance = sum(depositActivities())
        Money withdrawBalance = sum(withdrawActivities())
        despositBalance - withdrawBalance
    }

    private Money sum(List<Activity> activities){
        activities.inject(Money.ZERO){ totalMoney, activity -> //Inject works like reduce
            totalMoney + activity.money
        }
    }

    List<Activity> depositActivities(List<Activity> activities){
        activities.findAll{ it.operation == AccountOperation.ADD }
    }

    List<Activity> withdrawActivities(List<Activity> activities) {
        activities.findAll { it.operation == AccountOperation.WITHDRAW}
    }

    void add(Activity activity){
        assert activity
        activities.add(activity)
    }
}
