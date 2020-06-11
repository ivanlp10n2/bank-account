package domain.client.account.activity

import domain.client.account.Account
import domain.client.account.money.Money


class ActivityFrame {
    final List<Activity> activities

    private ActivityFrame(List<Activity> activities){
        this.activities = activities
    }

    static ActivityFrame from(List<Activity> activities){
        assert activities
        new ActivityFrame(activities)
    }

    static ActivityFrame empty(){
        new ActivityFrame(new ArrayList<Activity>())
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
