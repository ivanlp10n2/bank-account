package persistence.client.account

import domain.client.account.activity.Activity
import domain.client.account.activity.ActivityFrame
import persistence.client.account.model.ActivityDTO
import persistence.client.account.model.MoneyDTO
import persistence.shared.Utils

import java.time.LocalDateTime

class ActivityMapper {
    ActivityDTO map(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO()
        activityDTO.activityId = Utils.random()
        activityDTO.operation = activity.operation.name()
        activityDTO.balance = MoneyDTO.of(activity.money.currency.name(), activity.money.amount)
        activityDTO.timestamp = LocalDateTime.now()
    }

    Activity map(ActivityDTO sObj) {
        return null
    }

    List<ActivityDTO> mapActivities(ActivityFrame activities){
        mapActivities(activities.activities)
    }

    List<ActivityDTO> mapActivities(List<Activity> activities){
        List<ActivityDTO> activitiesDTO = new ArrayList<>()
        activities.each { activity ->
            activitiesDTO.add(map(activity))
        }
        activitiesDTO
    }
}
