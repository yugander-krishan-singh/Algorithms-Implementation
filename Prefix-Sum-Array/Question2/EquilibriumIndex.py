def getPrefixSumArray(arr):
    for i in range (1,len(arr)):
        arr[i] += arr[i-1]
    
def getEquilibriumIndex(arr):
    getPrefixSumArray(arr)
    equilibriumIndex=-1
    for i in range(1,len(arr)-1):
        sum1= arr[i-1]
        sum2 = arr[len(arr)-1] - arr[i]
        if sum1 == sum2:
            equilibriumIndex=i
            break;
    return equilibriumIndex   

print(getEquilibriumIndex([12,3,4,5]))
