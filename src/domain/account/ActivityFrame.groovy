package domain.account

class ActivityFrame {
    List<Activity> activities

    ActivityFrame(List<Activity> activities){
        assert activities
        this.activities = activities
    }

    Money calculateBalance(Account.AccountId accountId){

        Money despositBalance = sum(depositActivities())
        Money withdrawBalance = sum(withdrawActivities())

        despositBalance - withdrawBalance
    }

    List<Activity> depositActivities(List<Activity> activities){
        activities.findAll{ it.operation == AccountOperation.ADD }
    }

    private Money sum(List<Activity> activities){
        activities.inject(Money.ZERO){ totalMoney, activity -> //Inject works like reduce
            totalMoney.add(activity.money)
        }
    }

    List<Activity> withdrawActivities(List<Activity> activities) {
        activities.findAll { it.operation == AccountOperation.WITHDRAW}
    }


    void add(Activity activity){
        assert activity
        activities.add(activity)
    }
}
